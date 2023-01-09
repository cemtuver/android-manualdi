package tuver.manualdi.ui.characterdetail

import tuver.manualdi.model.Character

sealed class CharacterDetailViewState {
    object Loading : CharacterDetailViewState()
    data class Error(val errorMessage: String) : CharacterDetailViewState()
    data class Success(val character: Character) : CharacterDetailViewState()
}