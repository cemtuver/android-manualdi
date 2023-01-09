package tuver.manualdi.ui.di

import tuver.manualdi.provider.WebImageProvider

interface CharacterListModule : CharacterModule {

    val webImageProvider: WebImageProvider

}