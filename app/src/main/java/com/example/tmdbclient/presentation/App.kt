package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.daggerInject.Injector
import com.example.tmdbclient.presentation.daggerInject.MovieSubComponent
import com.example.tmdbclient.presentation.daggerInject.core.AppComponent
import com.example.tmdbclient.presentation.daggerInject.core.AppModule
import com.example.tmdbclient.presentation.daggerInject.core.DaggerAppComponent
import com.example.tmdbclient.presentation.daggerInject.core.NetModule
import com.example.tmdbclient.presentation.daggerInject.core.RemoteDataModule

class App : Application(), Injector{
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}