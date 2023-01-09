package tuver.manualdi.domain

import tuver.manualdi.model.Character

interface GetCharacterUseCase {

    suspend fun getCharacter(id: Int): Character

}