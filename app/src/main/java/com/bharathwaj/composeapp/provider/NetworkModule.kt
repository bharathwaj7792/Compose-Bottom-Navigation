package com.bharathwaj.composeapp.provider

import com.bharathwaj.composeapp.network.NetworkService
import com.bharathwaj.composeapp.repository.NetworkRepository
import com.bharathwaj.composeapp.repository.NetworkRepositoryImpl
import com.bharathwaj.composeapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): NetworkService {
        return NetworkService(retrofit)
    }

    @Provides
    @Singleton
    fun provideNetworkRepository(networkService: NetworkService): NetworkRepository{
        return NetworkRepositoryImpl(networkService)
    }

    private class AuthInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Authorization", Constants.ACCESS_TOKEN)

            val request: Request = requestBuilder.build()
            return chain.proceed(request)
        }
    }
}