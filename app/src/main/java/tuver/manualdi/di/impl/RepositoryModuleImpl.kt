package tuver.manualdi.di.impl

import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.data.impl.CharacterRepositoryImpl
import tuver.manualdi.di.RepositoryModule

class RepositoryModuleImpl : RepositoryModule {

    override val characterRepository: CharacterRepository by lazy {
        CharacterRepositoryImpl()
    }

}