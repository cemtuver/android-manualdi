package tuver.manualdi.di.impl

import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.data.CharacterRepository
import tuver.manualdi.data.impl.CharacterRepositoryImpl
import tuver.manualdi.di.RepositoryModule

class RepositoryModuleImpl : RepositoryModule {

    override val characterRepository: CharacterRepository by lazy {
        with(appModule) { CharacterRepositoryImpl.create() }
    }

}