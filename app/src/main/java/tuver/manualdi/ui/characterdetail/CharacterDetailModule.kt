package tuver.manualdi.ui.characterdetail

import tuver.manualdi.di.AppModule
import tuver.manualdi.provider.WebImageProvider
import tuver.manualdi.provider.impl.WebImageProviderImpl

class CharacterDetailModule(
    appModule: AppModule,
    private val characterDetailFragment: CharacterDetailFragment
) : AppModule by appModule {

    val webImageProvider: WebImageProvider by lazy {
        WebImageProviderImpl(characterDetailFragment)
    }

}