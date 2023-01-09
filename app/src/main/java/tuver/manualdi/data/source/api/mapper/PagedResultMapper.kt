package tuver.manualdi.data.source.api.mapper

import tuver.manualdi.data.source.api.dto.PagedResultDto
import tuver.manualdi.data.source.api.dto.PagedResultInfoDto
import tuver.manualdi.model.PagedResult
import tuver.manualdi.model.PagedResultInfo

class PagedResultMapper<TSource, TTarget>(
    private val pagedResultInfoMapper: DtoMapper<PagedResultInfoDto, PagedResultInfo>,
    private val itemMapper: DtoMapper<TSource, TTarget>
) : DtoMapper<PagedResultDto<TSource>, PagedResult<TTarget>> {

    override fun map(source: PagedResultDto<TSource>): PagedResult<TTarget> {
        return source.run {
            PagedResult(
                info.let(pagedResultInfoMapper::map),
                itemList.map(itemMapper::map)
            )
        }
    }

}