package tuver.manualdi.ui.di

import tuver.manualdi.provider.WebImageProvider

interface CharacterDetailModule : CharacterModule {

    val webImageProvider: WebImageProvider

}