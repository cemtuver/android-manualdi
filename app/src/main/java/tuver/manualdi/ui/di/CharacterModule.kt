package tuver.manualdi.ui.di

import tuver.manualdi.di.AppModule
import tuver.manualdi.ui.CharacterTacker

interface CharacterModule : AppModule {

    val characterTacker: CharacterTacker

}