package com.alaingauthier1.iconvert.di

import com.alaingauthier1.rates_repository.RatesApiService
import com.alaingauthier1.user_settings.UserSettings
import com.alaingauthier1.user_settings_impl.UserSettingsImpl
import com.alaingauthier1.rates_repository.RatesRepository
import com.alaingauthier1.rates_repository.di.RatesRepositoryModule
import com.alaingauthier1.rates_repository_impl.RatesApiServiceImpl
import com.alaingauthier1.rates_repository_impl.RatesRepositoryImpl
import com.alaingauthier1.retrofit.di.RetrofitModule
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    RetrofitModule::class,
    RatesRepositoryModule::class])
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindsRatesRepository(repoImpl: RatesRepositoryImpl): RatesRepository

    @Binds
    abstract fun bindsUserSettings(settingsImpl: UserSettingsImpl): UserSettings

    @Binds
    abstract fun bindsRatesApiService(ratesApiServiceImpl: RatesApiServiceImpl): RatesApiService
}