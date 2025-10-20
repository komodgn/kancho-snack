package com.komodgn.snack.feature.shoot.ocr.component

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.komodgn.snack.core.ui.component.SnackDialog
import com.komodgn.snack.feature.shoot.ocr.OcrUiState
import com.komodgn.snack.feature.shoot.R
import com.komodgn.snack.feature.shoot.ocr.OcrUiEvent

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    state: OcrUiState
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val permission = android.Manifest.permission.CAMERA

    val isGranted by produceState(
        initialValue = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED,
        key1 = lifecycleOwner
    ) {
        value = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                value = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
                if (value) {
                    state.eventSink(OcrUiEvent.OnHidePermissionDialog)
                } else {
                    state.eventSink(OcrUiEvent.OnShowPermissionDialog)
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        awaitDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { granted ->
        if (!granted) {
            state.eventSink(OcrUiEvent.OnShowPermissionDialog)
        }
    }

    val settingsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }

    LaunchedEffect(Unit) {
        if (!isGranted) {
            state.eventSink(OcrUiEvent.OnHidePermissionDialog)
            permissionLauncher.launch(permission)
        }
    }

    val cameraController = remember { LifecycleCameraController(context) }

    DisposableEffect(isGranted, lifecycleOwner, cameraController) {
        if (isGranted) {
            cameraController.bindToLifecycle(lifecycleOwner)
        }

        onDispose { cameraController.unbind() }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (isGranted) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    PreviewView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                        )
                        clipToOutline = true
                        implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                        scaleType = PreviewView.ScaleType.FILL_CENTER
                        controller = cameraController
                    }
                },
            )
        }
    }

    if (state.isCameraPermissionDialogVisible) {
        SnackDialog(
            title = stringResource(R.string.permission_dialog_title),
            description = stringResource(R.string.permission_dialog_description),
            confirmText = stringResource(R.string.permission_dialog_move_to_settings),
            onConfirmClick = {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", context.packageName, null)
                }
                settingsLauncher.launch(intent)
            }
        )
    }
}
