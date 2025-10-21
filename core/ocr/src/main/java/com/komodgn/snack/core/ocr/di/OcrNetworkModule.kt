package com.komodgn.snack.core.ocr.di

import com.komodgn.snack.core.ocr.BuildConfig
import com.komodgn.snack.core.ocr.service.OcrService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_SERVER_URL = "https://vision.googleapis.com/"
private const val MAX_TIMEOUT_MILLS = 10_000L

private val jsonRule = Json {
    encodeDefaults = true
    ignoreUnknownKeys = true
    prettyPrint = true
    isLenient = true
}

private val jsonConverterFactory = jsonRule.asConverterFactory("application/json".toMediaType())

@Module
@InstallIn(SingletonComponent::class)
object OcrNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp() : OkHttpClient {
        val log = HttpLoggingInterceptor().apply {
            redactHeader("X-Goog-Api-Key")
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BASIC
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        return OkHttpClient.Builder()
            .addInterceptor(log)
            .connectTimeout(MAX_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
            .readTimeout(MAX_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
            .writeTimeout(MAX_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(jsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideOcrService(
        retrofit: Retrofit
    ) : OcrService = retrofit.create(OcrService::class.java)
}


