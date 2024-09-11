package com.alaingauthier1.rates_repository.di

import com.alaingauthier1.rates_repository.api.RatesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RatesRepositoryModule {
    @Provides
    fun providesRatesApi(retrofit: Retrofit): RatesApi =
        retrofit.create(RatesApi::class.java)
}