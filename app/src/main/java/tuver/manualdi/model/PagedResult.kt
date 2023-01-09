package tuver.manualdi.model

data class PagedResult<T>(
    val info: PagedResultInfo,
    val itemList: List<T>
)