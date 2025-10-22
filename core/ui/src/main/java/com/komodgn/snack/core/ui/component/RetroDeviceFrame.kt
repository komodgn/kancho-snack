package com.komodgn.snack.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.komodgn.snack.core.designsystem.theme.Neutral900
import com.komodgn.snack.core.ui.R

/**
 * 레트로 게임기 본체 프레임 컴포넌트입니다.
 * * @param modifier Modifier
 * @param topAreaContent 상단 제목/이름표 영역 콘텐츠
 * @param screenContent 기기 화면 중앙에 들어갈 콘텐츠 (카메라 프리뷰 등)
 * @param buttonAreaContent 하단 버튼 영역 콘텐츠
 */
@Composable
fun RetroDeviceFrame(
    modifier: Modifier = Modifier,
    topAreaContent: @Composable () -> Unit,
    screenContent: @Composable () -> Unit,
    buttonAreaContent: @Composable () -> Unit,
) {
    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1.15f),
    ) {
        Image(
            painter = painterResource(id = R.drawable.retro_device_frame),
            contentDescription = "Retro Game Device Frame",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
        )

        ConstraintLayout(
            modifier = Modifier.matchParentSize(),
        ) {
            val (topRef, screenRef, buttonsRef) = createRefs()

            Box(
                modifier =
                    Modifier.Companion
                        .constrainAs(topRef) {
                            top.linkTo(parent.top, margin = 70.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent
                        }.padding(horizontal = 32.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                topAreaContent()
            }

            Box(
                modifier =
                    Modifier.Companion
                        .constrainAs(screenRef) {
                            top.linkTo(topRef.bottom, margin = 20.dp)
                            bottom.linkTo(parent.bottom, margin = 160.dp)
                            start.linkTo(parent.start, margin = 88.dp)
                            end.linkTo(parent.end, margin = 88.dp)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        }.background(Neutral900),
            ) {
                screenContent()
            }

            Box(
                modifier =
                    Modifier.Companion.constrainAs(buttonsRef) {
                        bottom.linkTo(parent.bottom, margin = 100.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    },
                contentAlignment = Alignment.Center,
            ) {
                buttonAreaContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RetroDeviceFramePreview() {
    RetroDeviceFrame(
        topAreaContent = { Text("칸쵸 태그") },
        screenContent = { Text("카메라 영역") },
        buttonAreaContent = {
            Row {
                Button(onClick = {}) { Text("Shoot") }
                Button(onClick = {}) { Text("Gallery") }
                Button(onClick = {}) { Text("Share") }
            }
        },
    )
}
