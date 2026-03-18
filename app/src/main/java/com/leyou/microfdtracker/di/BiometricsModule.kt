package com.leyou.microfdtracker.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.leyou.microfdtracker.data.repository.BiometricAuthRepositoryImpl
import com.leyou.microfdtracker.domain.repository.BiometricAuthRepository
import com.leyou.microfdtracker.domain.usecase.biometrics.BiometricAvailabilityUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BiometricsModule {

    @Binds
    @Singleton
    abstract fun bindsBiometricAuthRepository(
        biometricAuthRepoImpl: BiometricAuthRepositoryImpl
    ): BiometricAuthRepository



    companion object{
        @Provides
        fun providesBiometricAvailabilityUseCase(
            @ApplicationContext context: Context,
            repository: BiometricAuthRepository
        ):BiometricAvailabilityUseCase{
            return BiometricAvailabilityUseCase(context,repository)
        }

    }

}
