package tuver.manualdi.di.impl

import tuver.manualdi.ManualDiApplication.Companion.appModule
import tuver.manualdi.di.ProviderModule
import tuver.manualdi.provider.CoroutineContextProvider
import tuver.manualdi.provider.SerializationProvider
import tuver.manualdi.provider.impl.CoroutineContextProviderImpl
import tuver.manualdi.provider.impl.SerializationProviderImpl

class ProviderModuleImpl : ProviderModule {

    override val coroutineContextProvider: CoroutineContextProvider by lazy {
        with(appModule) { CoroutineContextProviderImpl.create() }
    }

    override val serializationProvider: SerializationProvider by lazy {
        with(appModule) { SerializationProviderImpl.create() }
    }

}