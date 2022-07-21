package com.randomapps.randomnumber.di

import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.usecase.AddGeneratorUseCase
import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import com.randomapps.randomgenerator.domain.usecase.GetAllGeneratorsUseCase
import com.randomapps.randomgenerator.domain.usecase.impl.AddGeneratorUseCaseImpl
import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import com.randomapps.randomgenerator.domain.usecase.impl.GetAllGeneratorsUseCaseImpl
import com.randomnumber.data.NumberGeneratorStubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideRepository(): GeneratorRepository {
        return NumberGeneratorStubRepository()
    }
    @Provides
    fun provideGenerateNumberUseCase(): GenerateNumberUseCase {
        return GenerateNumberUseCaseImpl()
    }
    @Provides
    fun provideAddGeneratorUseCase(
        repository: GeneratorRepository
    ): AddGeneratorUseCase {
        return AddGeneratorUseCaseImpl(repository)
    }
    @Provides
    fun provideGetAllGeneratorsUseCase(
        repository: GeneratorRepository
    ) : GetAllGeneratorsUseCase {
        return GetAllGeneratorsUseCaseImpl(repository)
    }
}
