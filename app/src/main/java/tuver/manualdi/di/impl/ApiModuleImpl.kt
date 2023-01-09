package tuver.manualdi.di.impl

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import tuver.manualdi.BuildConfig
import tuver.manualdi.data.source.api.CharacterApi
import tuver.manualdi.di.ApiModule
import tuver.manualdi.di.ProviderModule
import tuver.manualdi.util.extension.debugLoggingInterceptor
import java.util.concurrent.TimeUnit

class ApiModuleImpl(providerModule: ProviderModule) : ApiModule {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(providerModule.serializationProvider.createConverterFactory(CONTENT_TYPE_JSON))
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_CONNECT_IN_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ_IN_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE_IN_SECONDS, TimeUnit.SECONDS)
            .debugLoggingInterceptor()
            .build()
    }

    override val characterApi: CharacterApi by lazy {
        retrofit.create()
    }

    companion object {

        private const val BASE_URL = BuildConfig.API_BASE_URL
        private const val CONTENT_TYPE_JSON = "application/json"
        private const val TIMEOUT_CONNECT_IN_SECONDS = 10L
        private const val TIMEOUT_READ_IN_SECONDS = 30L
        private const val TIMEOUT_WRITE_IN_SECONDS = 30L

    }

}