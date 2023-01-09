package tuver.manualdi.domain.impl

import androidx.paging.PagingSource
import androidx.paging.PagingState
import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.model.Character

class CharacterListPagingSource(
    private val characterRepository: CharacterRepository
) : PagingSource<String, Character>() {

    override fun getRefreshKey(state: PagingState<String, Character>): String? {
        // TODO
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> {
        val key = params.key
        val response = when (key) {
            null -> characterRepository.getCharacterList()
            else -> characterRepository.getCharacterList(key)
        }

        return response.run {
            LoadResult.Page(itemList, info.previousPage, info.nextPage)
        }
    }

}
