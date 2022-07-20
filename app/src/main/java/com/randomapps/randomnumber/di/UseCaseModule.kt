package com.randomapps.randomnumber.di

import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.usecase.impl.AddGeneratorUseCaseImpl
import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideGenerateNumberUseCase(
        generateNumberUseCaseImpl: GenerateNumberUseCaseImpl): GenerateNumberUseCaseImpl {
        return generateNumberUseCaseImpl
    }
    @Provides
    fun provideAddGeneratorUseCase(
        repository: GeneratorRepository
    ): AddGeneratorUseCaseImpl {
        return AddGeneratorUseCaseImpl(repository)
    }
}
