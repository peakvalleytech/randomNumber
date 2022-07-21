package com.randomapps.randomnumber.di

import android.app.Application
import android.content.Context
import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import com.randomapps.randomnumber.ui.screens.generator.GeneratorViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

//@Module
//@InstallIn(ViewModelComponent::class)
//class ViewModelModule {
////    @Provides
////    fun provideGeneratorViewModel(@ApplicationContext context : Context) : GeneratorViewModel {
////        return GeneratorViewModel(, context as Application)
////    }
//}