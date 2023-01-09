package tuver.manualdi.provider.impl

import kotlinx.coroutines.Dispatchers
import tuver.manualdi.di.AppModule
import tuver.manualdi.provider.CoroutineContextProvider
import kotlin.coroutines.CoroutineContext

class CoroutineContextProviderImpl : CoroutineContextProvider {

    override val io: CoroutineContext = Dispatchers.IO

    companion object {

        context(AppModule)
        fun create(): CoroutineContextProviderImpl {
            return CoroutineContextProviderImpl()
        }

    }

}