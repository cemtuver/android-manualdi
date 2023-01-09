package tuver.manualdi.model

data class PagedResultInfo(
    val itemCount: Int,
    val pageCount: Int,
    val nextPage: String?,
    val previousPage: String?
)