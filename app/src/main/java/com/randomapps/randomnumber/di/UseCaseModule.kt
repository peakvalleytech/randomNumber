package com.randomapps.randomnumber.di

import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideGenerateNumberUseCase(
        generateNumberUseCaseImpl: GenerateNumberUseCaseImpl): GenerateNumberUseCaseImpl {
        return generateNumberUseCaseImpl
    }
}
