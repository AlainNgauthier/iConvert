package com.alaingauthier1.retrofit.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Converter.Factory
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val RATES_BASE_URL = "https://www.frankfurter.app/"

    @Provides
    @Singleton
    fun providesRetrofit(factory: Factory): Retrofit = Retrofit.Builder()
        .baseUrl(RATES_BASE_URL)
        .addConverterFactory(factory)
        .build()

    @Provides
    @Singleton
    fun providesConvertorFactory():Converter.Factory =
        Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType())
}