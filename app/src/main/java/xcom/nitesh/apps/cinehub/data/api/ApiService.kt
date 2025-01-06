package xcom.nitesh.apps.cinehub.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xcom.nitesh.apps.cinehub.Model.UpComingMoview

interface ApiService {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query ("api_key") apiKey : String,
        @Query("language") language: String = "en-US",
        @Query("page") page : Int = 1
    ) : Response<UpComingMoview>
}