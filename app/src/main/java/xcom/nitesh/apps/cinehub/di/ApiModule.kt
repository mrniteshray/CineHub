package xcom.nitesh.apps.cinehub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xcom.nitesh.apps.cinehub.data.api.ApiService
import xcom.nitesh.apps.cinehub.utils.Constants
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Singleton
    @Provides
    fun getRetro() : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun getApiService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

}