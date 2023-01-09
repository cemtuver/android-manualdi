package tuver.manualdi.data.impl

import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.data.source.api.CharacterApi
import tuver.manualdi.data.source.api.dto.CharacterDto
import tuver.manualdi.data.source.api.dto.PagedResultDto
import tuver.manualdi.data.source.api.mapper.DtoMapper
import tuver.manualdi.model.Character
import tuver.manualdi.model.PagedResult

class CharacterRepositoryImpl(
    private val characterApi: CharacterApi = appModule.characterApi,
    private val characterMapper: DtoMapper<CharacterDto, Character> = appModule.characterMapper,
    private val characterPagedResultMapper: DtoMapper<PagedResultDto<CharacterDto>, PagedResult<Character>> = appModule.characterPagedResultMapper
) : CharacterRepository {

    override suspend fun getCharacterList(): PagedResult<Character> {
        return characterApi.getCharacterList().let(characterPagedResultMapper::map)
    }

    override suspend fun getCharacterList(page: String): PagedResult<Character> {
        return characterApi.getCharacterList(page).let(characterPagedResultMapper::map)
    }

    override suspend fun getCharacter(id: Int): Character {
        return characterApi.getCharacter(id).let(characterMapper::map)
    }

}