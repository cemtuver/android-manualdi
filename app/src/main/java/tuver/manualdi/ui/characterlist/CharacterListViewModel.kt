package tuver.manualdi.ui.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.liveData
import kotlinx.coroutines.launch
import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.domain.GetCharacterListPagerUseCase
import tuver.manualdi.model.Character
import tuver.manualdi.util.SingleLiveEvent

class CharacterListViewModel(
    private val getCharacterListPagerUseCase: GetCharacterListPagerUseCase = appModule.getCharacterListPagerUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<CharacterListViewState>()

    private val viewAction = SingleLiveEvent<CharacterListViewAction>()

    init {
        getCharacterListPagingSource()
    }

    private fun getCharacterListPagingSource() {
        viewState.postValue(CharacterListViewState.Loading)
        viewModelScope.launch {
            val characterListPager = getCharacterListPagerUseCase.getCharacterListPager()

            onNetworkEventGetCharacterListPagerSuccess(characterListPager)
        }
    }

    private fun onNetworkEventGetCharacterListPagerSuccess(characterListPager: Pager<String, Character>) {
        val characterListPagingData = characterListPager.liveData.cachedIn(viewModelScope)
        val state = CharacterListViewState.Success(characterListPagingData)

        viewState.postValue(state)
    }

    fun viewState(): LiveData<CharacterListViewState> {
        return viewState
    }

    fun viewAction(): LiveData<CharacterListViewAction> {
        return viewAction
    }

    fun onUserEventCharacterClicked(character: Character) {
        val action = CharacterListViewAction.NavigateToCharacterDetail(
            character.id,
            character.name
        )

        viewAction.postValue(action)
    }

}