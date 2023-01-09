package tuver.manualdi.di

import tuver.manualdi.domain.GetCharacterListPagerUseCase
import tuver.manualdi.domain.GetCharacterUseCase

interface DomainModule {

    val getCharacterListPagerUseCase: GetCharacterListPagerUseCase

    val getCharacterUseCase: GetCharacterUseCase

}