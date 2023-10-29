package `is`.ulstu.feature.catalog.dto

@kotlinx.serialization.Serializable
data class RatedValueDto(
    val value: String,
    val rate: RateDto,
)
