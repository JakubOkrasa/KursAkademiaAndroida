package pl.jakubokrasa.kursakademiaandroida.core.di

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.jakubokrasa.kursakademiaandroida.BuildConfig
import pl.jakubokrasa.kursakademiaandroida.features.data.RickAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Interceptor> {
        HttpLoggingInterceptor()
            .apply {
                level =
                    if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE // dzięki temu w wersji produkcyjnej, logi nie będą widoczne
            }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single { get<Retrofit>().create(RickAndMortyApi::class.java)}
}