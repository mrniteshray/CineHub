package xcom.nitesh.apps.cinehub.data.repository

import xcom.nitesh.apps.cinehub.Model.UpComingMoview
import xcom.nitesh.apps.cinehub.data.api.ApiService
import xcom.nitesh.apps.cinehub.utils.Constants
import javax.inject.Inject

class MovieRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getUpcomingMovies() : UpComingMoview? {
        return apiService.getUpcomingMovies(Constants.APIKEY).body()
    }
}