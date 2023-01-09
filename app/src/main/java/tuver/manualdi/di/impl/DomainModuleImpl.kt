package tuver.manualdi.di.impl

import tuver.manualdi.di.DomainModule
import tuver.manualdi.domain.GetCharacterListPagerUseCase
import tuver.manualdi.domain.GetCharacterUseCase
import tuver.manualdi.domain.impl.GetCharacterListPagerUseCaseImpl
import tuver.manualdi.domain.impl.GetCharacterUseCaseImpl

class DomainModuleImpl : DomainModule {

    override val getCharacterListPagerUseCase: GetCharacterListPagerUseCase by lazy {
        GetCharacterListPagerUseCaseImpl()
    }

    override val getCharacterUseCase: GetCharacterUseCase by lazy {
        GetCharacterUseCaseImpl()
    }

}