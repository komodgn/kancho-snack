package com.komodgn.snack.core.ocr.model

import kotlinx.serialization.Serializable

@Serializable
data class OcrResponse(
    val responses: List<AnnotateImageResponse>
)

@Serializable
data class AnnotateImageResponse(
    val textAnnotations: List<EntityAnnotation>? = null
)

@Serializable
data class EntityAnnotation(
    val description: String,
    val boundingPoly: BoundingPoly,
    val score: Float? = null,
    val local: String? =null
)

@Serializable
data class BoundingPoly(
    val vertices: List<Vertex>
)

@Serializable
data class Vertex(
    val x: Int,
    val y: Int
)