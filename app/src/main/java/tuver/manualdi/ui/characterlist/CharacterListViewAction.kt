package tuver.manualdi.ui.characterlist

sealed class CharacterListViewAction {
    data class NavigateToCharacterDetail(
        val characterId: Int,
        val characterName: String
    ) : CharacterListViewAction()
}