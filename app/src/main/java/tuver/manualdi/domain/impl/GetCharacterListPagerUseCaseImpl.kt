package tuver.manualdi.domain.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.withContext
import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.domain.GetCharacterListPagerUseCase
import tuver.manualdi.model.Character
import tuver.manualdi.provider.CoroutineContextProvider

class GetCharacterListPagerUseCaseImpl(
    private val coroutineContextProvider: CoroutineContextProvider = appModule.coroutineContextProvider,
    private val characterRepository: CharacterRepository = appModule.characterRepository
) : GetCharacterListPagerUseCase {

    override suspend fun getCharacterListPager(): Pager<String, Character> = withContext(coroutineContextProvider.io) {
        val pagingConfig = PagingConfig(20)
        val pagingSource = CharacterListPagingSource(characterRepository)

        Pager(pagingConfig) { pagingSource }
    }

}