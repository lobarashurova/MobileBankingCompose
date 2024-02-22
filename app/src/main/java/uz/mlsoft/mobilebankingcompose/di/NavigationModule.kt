package uz.mlsoft.mobilebankingcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mlsoft.mobilebankingcompose.presentation.login.LoginDirection
import uz.mlsoft.mobilebankingcompose.presentation.login.LoginDirectionImpl
import uz.mlsoft.mobilebankingcompose.presentation.registration.RegisterDirection
import uz.mlsoft.mobilebankingcompose.presentation.registration.RegisterDirectionImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @[Binds Singleton]
    fun bindRegisterDirection(impl: RegisterDirectionImpl): RegisterDirection

    @[Binds Singleton]
    fun bindLoginDirection(impl: LoginDirectionImpl): LoginDirection

}