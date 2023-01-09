package tuver.manualdi.di.impl

import tuver.manualdi.di.ProviderModule
import tuver.manualdi.provider.CoroutineContextProvider
import tuver.manualdi.provider.impl.SerializationProviderImpl
import tuver.manualdi.provider.SerializationProvider
import tuver.manualdi.provider.impl.CoroutineContextProviderImpl

class ProviderModuleImpl : ProviderModule {

    override val coroutineContextProvider: CoroutineContextProvider by lazy {
        CoroutineContextProviderImpl()
    }

    override val serializationProvider: SerializationProvider by lazy {
        SerializationProviderImpl()
    }

}