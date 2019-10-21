package com.mac.testdemo.injection

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.lifecycle.ViewModelProvider
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mac.testdemo.BuildConfig
import com.mac.testdemo.network.Repository
import com.mac.testdemo.network.WebService
import com.mac.testdemo.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient as OkHttpClient1

@Module
class UtilModule {


    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val builder =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.setLenient().create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient1): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://13.232.52.221:8000/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun getApiCallInterface(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

    @Provides
    @Singleton
    fun getRequestHeader(): OkHttpClient1 {

        val httpClient = OkHttpClient1.Builder()

        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .build()
                chain.proceed(request)
            }
                .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))

        } else {
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .build()
                chain.proceed(request)
            }

        }

            .connectTimeout(500, TimeUnit.SECONDS)
            .writeTimeout(500, TimeUnit.SECONDS)
            .readTimeout(500, TimeUnit.SECONDS)


        return httpClient.build()
    }

    @Provides
    @Singleton
    fun getRepository(apiCallInterface: WebService): Repository {
        return Repository(apiCallInterface)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(myRepository: Repository): ViewModelProvider.Factory {
        return ViewModelFactory(myRepository)
    }


    @Provides
    @Singleton
    fun providesSharedPreferences(ctx: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

}