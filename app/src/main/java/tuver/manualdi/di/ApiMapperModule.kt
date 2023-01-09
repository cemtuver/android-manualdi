package tuver.manualdi.di

import tuver.manualdi.data.source.api.dto.CharacterDto
import tuver.manualdi.data.source.api.dto.PagedResultDto
import tuver.manualdi.data.source.api.mapper.DtoMapper
import tuver.manualdi.model.Character
import tuver.manualdi.model.PagedResult

interface ApiMapperModule {

    val characterMapper: DtoMapper<CharacterDto, Character>

    val characterPagedResultMapper: DtoMapper<PagedResultDto<CharacterDto>, PagedResult<Character>>

}