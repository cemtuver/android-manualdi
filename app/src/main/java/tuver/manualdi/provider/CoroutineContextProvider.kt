package tuver.manualdi.provider

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {

    val io: CoroutineContext

}