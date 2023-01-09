package tuver.manualdi.data.source.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedResultDto<T>(
    @SerialName("info") val info: PagedResultInfoDto,
    @SerialName("results") val itemList: List<T>
)