package tuver.manualdi.ui.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.domain.GetCharacterUseCase
import tuver.manualdi.model.Character

class CharacterDetailViewModel(
    private val characterId: Int,
    private val getCharacterUseCase: GetCharacterUseCase = appModule.getCharacterUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<CharacterDetailViewState>()

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewState.postValue(CharacterDetailViewState.Loading)
        viewModelScope.launch {
            val character = getCharacterUseCase.getCharacter(characterId)

            onNetworkEventGetCharacterSuccess(character)
        }
    }

    private fun onNetworkEventGetCharacterSuccess(character: Character) {
        val state = CharacterDetailViewState.Success(
            character
        )

        viewState.postValue(state)
    }

    fun viewState(): LiveData<CharacterDetailViewState> {
        return viewState
    }

}
