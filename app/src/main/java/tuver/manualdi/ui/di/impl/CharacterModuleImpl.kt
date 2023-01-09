package tuver.manualdi.ui.di.impl

import tuver.manualdi.di.AppModule
import tuver.manualdi.ui.CharacterTacker
import tuver.manualdi.ui.di.CharacterModule

class CharacterModuleImpl(
    private val appModule: AppModule
) : CharacterModule, AppModule by appModule {

    override val characterTacker: CharacterTacker by lazy {
        CharacterTacker()
    }

}
