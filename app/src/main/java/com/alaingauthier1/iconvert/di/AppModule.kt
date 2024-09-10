package com.alaingauthier1.iconvert.di

import com.alaingauthier1.iconvert.UserSettings
import com.alaingauthier1.iconvert.UserSettingsImpl
import com.alaingauthier1.iconvert.model.RatesRepository
import com.alaingauthier1.iconvert.model.RatesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindsRatesRepository(repoImpl: RatesRepositoryImpl): RatesRepository

    @Binds
    abstract fun bindsUserSettings(settingsImpl: UserSettingsImpl): UserSettings
}