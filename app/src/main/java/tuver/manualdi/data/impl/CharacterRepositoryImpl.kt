package tuver.manualdi.data.impl

import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.data.source.api.CharacterApi
import tuver.manualdi.data.source.api.dto.CharacterDto
import tuver.manualdi.data.source.api.dto.PagedResultDto
import tuver.manualdi.data.source.api.mapper.DtoMapper
import tuver.manualdi.di.AppModule
import tuver.manualdi.model.Character
import tuver.manualdi.model.PagedResult

class CharacterRepositoryImpl(
    private val characterApi: CharacterApi,
    private val characterMapper: DtoMapper<CharacterDto, Character>,
    private val characterPagedResultMapper: DtoMapper<PagedResultDto<CharacterDto>, PagedResult<Character>>
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

    companion object {

        context(AppModule)
        fun create() = CharacterRepositoryImpl(
            characterApi,
            characterMapper,
            characterPagedResultMapper
        )

    }

}