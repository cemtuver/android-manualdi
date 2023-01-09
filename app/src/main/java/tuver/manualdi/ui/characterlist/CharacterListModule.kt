package tuver.manualdi.ui.characterlist

import tuver.manualdi.di.AppModule
import tuver.manualdi.provider.WebImageProvider
import tuver.manualdi.provider.impl.WebImageProviderImpl

class CharacterListModule(
    appModule: AppModule,
    private val characterListFragment: CharacterListFragment
) : AppModule by appModule {

    val webImageProvider: WebImageProvider by lazy {
        WebImageProviderImpl(characterListFragment)
    }

}