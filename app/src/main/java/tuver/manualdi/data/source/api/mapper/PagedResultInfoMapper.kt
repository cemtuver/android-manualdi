package tuver.manualdi.data.source.api.mapper

import tuver.manualdi.data.source.api.dto.PagedResultInfoDto
import tuver.manualdi.model.PagedResultInfo

class PagedResultInfoMapper : DtoMapper<PagedResultInfoDto, PagedResultInfo> {

    override fun map(source: PagedResultInfoDto): PagedResultInfo {
        return source.run {
            PagedResultInfo(
                itemCount,
                pageCount,
                nextPage,
                previousPage
            )
        }
    }

}