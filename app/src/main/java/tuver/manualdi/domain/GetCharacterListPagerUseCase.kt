package tuver.manualdi.domain

import androidx.paging.Pager
import tuver.manualdi.model.Character

interface GetCharacterListPagerUseCase {

    suspend fun getCharacterListPager(): Pager<String, Character>

}