package tuver.manualdi.di

import tuver.manualdi.provider.CoroutineContextProvider
import tuver.manualdi.provider.SerializationProvider

interface ProviderModule {

    val coroutineContextProvider: CoroutineContextProvider

    val serializationProvider: SerializationProvider

}