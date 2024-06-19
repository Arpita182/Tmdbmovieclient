package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.presentation.daggerInject.MovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModel::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
}