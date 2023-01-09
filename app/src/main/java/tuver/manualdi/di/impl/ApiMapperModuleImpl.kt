package tuver.manualdi.di.impl

import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.data.source.api.dto.CharacterDto
import tuver.manualdi.data.source.api.dto.PagedResultDto
import tuver.manualdi.data.source.api.dto.PagedResultInfoDto
import tuver.manualdi.data.source.api.mapper.CharacterMapper
import tuver.manualdi.data.source.api.mapper.DtoMapper
import tuver.manualdi.data.source.api.mapper.PagedResultInfoMapper
import tuver.manualdi.data.source.api.mapper.PagedResultMapper
import tuver.manualdi.di.ApiMapperModule
import tuver.manualdi.model.Character
import tuver.manualdi.model.PagedResult
import tuver.manualdi.model.PagedResultInfo

class ApiMapperModuleImpl : ApiMapperModule {

    private val pagedResultInfoMapper: DtoMapper<PagedResultInfoDto, PagedResultInfo> by lazy {
        with(appModule) { PagedResultInfoMapper.create() }
    }

    override val characterMapper: DtoMapper<CharacterDto, Character> by lazy {
        with(appModule) { CharacterMapper.create() }
    }

    override val characterPagedResultMapper: DtoMapper<PagedResultDto<CharacterDto>, PagedResult<Character>> by lazy {
        with(appModule) { PagedResultMapper.create(pagedResultInfoMapper, characterMapper) }
    }

}