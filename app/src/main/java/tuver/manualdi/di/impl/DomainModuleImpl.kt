package tuver.manualdi.di.impl

import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.di.DomainModule
import tuver.manualdi.domain.GetCharacterListPagerUseCase
import tuver.manualdi.domain.GetCharacterUseCase
import tuver.manualdi.domain.impl.GetCharacterListPagerUseCaseImpl
import tuver.manualdi.domain.impl.GetCharacterUseCaseImpl

class DomainModuleImpl : DomainModule {

    override val getCharacterListPagerUseCase: GetCharacterListPagerUseCase by lazy {
        with(appModule) { GetCharacterListPagerUseCaseImpl.create() }
    }

    override val getCharacterUseCase: GetCharacterUseCase by lazy {
        with(appModule) { GetCharacterUseCaseImpl.create() }
    }

}