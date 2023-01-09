package tuver.manualdi.ui.characterlist

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import tuver.manualdi.model.Character

sealed class CharacterListViewState {
    object Loading : CharacterListViewState()
    data class Error(val errorMessage: String) : CharacterListViewState()
    data class Success(
        val characterListPagingData: LiveData<PagingData<Character>>
    ) : CharacterListViewState()
}