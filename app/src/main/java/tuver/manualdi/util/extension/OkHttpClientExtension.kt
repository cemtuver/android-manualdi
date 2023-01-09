package tuver.manualdi.util.extension

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import tuver.manualdi.BuildConfig

fun OkHttpClient.Builder.debugLoggingInterceptor() = apply {
    if (!BuildConfig.DEBUG) return@apply
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    addInterceptor(logging)
}