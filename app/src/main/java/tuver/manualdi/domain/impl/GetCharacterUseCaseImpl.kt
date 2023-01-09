package tuver.manualdi.domain.impl

import kotlinx.coroutines.withContext
import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.domain.GetCharacterUseCase
import tuver.manualdi.model.Character
import tuver.manualdi.provider.CoroutineContextProvider

class GetCharacterUseCaseImpl(
    private val coroutineContextProvider: CoroutineContextProvider = appModule.coroutineContextProvider,
    private val characterRepository: CharacterRepository = appModule.characterRepository
) : GetCharacterUseCase {

    override suspend fun getCharacter(id: Int): Character = withContext(coroutineContextProvider.io) {
        characterRepository.getCharacter(id)
    }

}