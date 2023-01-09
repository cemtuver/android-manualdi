package tuver.manualdi.ui.di.impl

import tuver.manualdi.provider.WebImageProvider
import tuver.manualdi.provider.impl.WebImageProviderImpl
import tuver.manualdi.ui.di.CharacterModule
import tuver.manualdi.ui.characterlist.CharacterListFragment
import tuver.manualdi.ui.di.CharacterListModule

class CharacterListModuleImpl(
    characterModule: CharacterModule,
    private val characterListFragment: CharacterListFragment
) : CharacterListModule, CharacterModule by characterModule {

    override val webImageProvider: WebImageProvider by lazy {
        WebImageProviderImpl.create(characterListFragment)
    }

}