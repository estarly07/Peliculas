package com.estarly.peliculas.data.hilt

import android.content.Context
import com.estarly.peliculas.data.sharedPreferences.SharedPreferences
import com.estarly.peliculas.data.usecases.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HiltModels {
    @Singleton
    @Provides
    fun providerUseCase(@ApplicationContext context: Context) : UseCase{
        return  UseCase(context)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context):SharedPreferences{
        return SharedPreferences(context)
    }

}