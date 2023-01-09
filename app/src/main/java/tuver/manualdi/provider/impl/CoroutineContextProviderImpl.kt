package tuver.manualdi.provider.impl

import kotlinx.coroutines.Dispatchers
import tuver.manualdi.provider.CoroutineContextProvider
import kotlin.coroutines.CoroutineContext

class CoroutineContextProviderImpl : CoroutineContextProvider {

    override val io: CoroutineContext = Dispatchers.IO

}