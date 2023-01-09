package tuver.manualdi.ui.di.impl

import tuver.manualdi.provider.WebImageProvider
import tuver.manualdi.provider.impl.WebImageProviderImpl
import tuver.manualdi.ui.di.CharacterModule
import tuver.manualdi.ui.characterdetail.CharacterDetailFragment
import tuver.manualdi.ui.di.CharacterDetailModule

class CharacterDetailModuleImpl(
    characterModule: CharacterModule,
    private val characterDetailFragment: CharacterDetailFragment
) : CharacterDetailModule, CharacterModule by characterModule {

    override val webImageProvider: WebImageProvider by lazy {
        WebImageProviderImpl.create(characterDetailFragment)
    }

}