package tuver.manualdi.data

import tuver.manualdi.model.Character
import tuver.manualdi.model.PagedResult

interface CharacterRepository {

    suspend fun getCharacterList(): PagedResult<Character>

    suspend fun getCharacterList(page: String): PagedResult<Character>

    suspend fun getCharacter(id: Int): Character

}