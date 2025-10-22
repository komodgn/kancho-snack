package com.komodgn.snack.core.ocr.service

import com.komodgn.snack.core.ocr.model.OcrRequest
import com.komodgn.snack.core.ocr.model.OcrResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OcrService {
    @POST("v1/images:annotate")
    suspend fun annotateImages(
        @Header("X-Goog-Api-Key") apiKey: String,
        @Body body: OcrRequest,
    ): OcrResponse
}
