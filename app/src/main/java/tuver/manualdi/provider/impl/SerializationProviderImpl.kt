package tuver.manualdi.provider.impl

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import tuver.manualdi.provider.SerializationProvider

class SerializationProviderImpl : SerializationProvider {

    private val json = Json { ignoreUnknownKeys = true }

    override fun createConverterFactory(contentType: String): Converter.Factory {
        return json.asConverterFactory(contentType.toMediaType())
    }

}