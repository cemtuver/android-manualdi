package tuver.manualdi.data.source.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedResultInfoDto(
    @SerialName("count") val itemCount: Int,
    @SerialName("pages") val pageCount: Int,
    @SerialName("next") val nextPage: String?,
    @SerialName("prev") val previousPage: String?
)