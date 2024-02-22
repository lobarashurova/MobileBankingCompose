package uz.mlsoft.mobilebankingcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mlsoft.mobilebankingcompose.util.AppNavigationDispatcher
import uz.mlsoft.mobilebankingcompose.util.AppNavigationHandler
import uz.mlsoft.mobilebankingcompose.util.AppNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @[Binds Singleton]
    fun provideNavigator(impl: AppNavigationDispatcher): AppNavigator

    @[Binds Singleton]
    fun provideNavigationHandler(impl: AppNavigationDispatcher): AppNavigationHandler
}