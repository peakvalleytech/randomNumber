package com.randomapps.randomnumber.di

import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import com.randomapps.randomnumber.ui.screens.generator.GeneratorViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {
    @Provides
    fun provideGeneratorViewModel() : GeneratorViewModel {
        return GeneratorViewModel(GenerateNumberUseCaseImpl())
    }
}