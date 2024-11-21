package com.example.autodigamecorner.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    fun provideHttpClient() = HttpClient(Android){
        install(ContentNegotiation){
            gson()
        }
    }
}