package com.komodgn.snack.core.ocr.model

import kotlinx.serialization.Serializable

@Serializable
data class OcrRequest(
    val requests: List<AnnotateImageRequest>,
)

@Serializable
data class AnnotateImageRequest(
    val image: OcrImage,
    val features: List<Feature>,
    val imageContext: ImageContext? = null,
)

@Serializable
data class OcrImage(
    val content: String,
)

@Serializable
data class Feature(
    val type: String = "TEXT_DETECTION",
)

@Serializable
data class ImageContext(
    val languageHints: List<String>? = null,
)
