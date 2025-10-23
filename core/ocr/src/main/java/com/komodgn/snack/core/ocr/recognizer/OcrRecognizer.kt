package com.komodgn.snack.core.ocr.recognizer

import android.net.Uri
import android.util.Base64
import com.komodgn.snack.core.ocr.BuildConfig
import com.komodgn.snack.core.ocr.model.AnnotateImageRequest
import com.komodgn.snack.core.ocr.model.Feature
import com.komodgn.snack.core.ocr.model.ImageContext
import com.komodgn.snack.core.ocr.model.OcrImage
import com.komodgn.snack.core.ocr.model.OcrRequest
import com.komodgn.snack.core.ocr.model.OcrResponse
import com.komodgn.snack.core.ocr.service.OcrService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.IOException
import javax.inject.Inject

class OcrRecognizer
    @Inject
    constructor(
        private val ocrService: OcrService,
    ) {
        @Suppress("TooGenericExceptionCaught")
        suspend fun recognizeText(imageUri: Uri): Result<OcrResponse> =
            withContext(Dispatchers.IO) {
                try {
                    val filePath = imageUri.path ?: throw IllegalArgumentException("Invalid Path")
                    val file = File(filePath)
                    val byte = file.readBytes()
                    val base64 = Base64.encodeToString(byte, Base64.NO_WRAP)

                    val request =
                        OcrRequest(
                            requests =
                                listOf(
                                    AnnotateImageRequest(
                                        image = OcrImage(base64),
                                        features = listOf(Feature()),
                                        imageContext = ImageContext(),
                                    ),
                                ),
                        )

                    val response =
                        ocrService.annotateImages(
                            apiKey = BuildConfig.CLOUD_VISION_API_KEY,
                            body = request,
                        )

                    Result.success(response)
                } catch (e: IOException) {
                    e.printStackTrace()
                    Result.failure(e)
                } catch (e: RuntimeException) {
                    e.printStackTrace()
                    Result.failure(e)
                }
            }
    }
