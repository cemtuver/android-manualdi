package tuver.manualdi.provider

import retrofit2.Converter

interface SerializationProvider {

    fun createConverterFactory(contentType: String): Converter.Factory

}