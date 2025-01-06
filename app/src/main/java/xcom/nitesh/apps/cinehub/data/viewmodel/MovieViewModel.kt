package xcom.nitesh.apps.cinehub.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xcom.nitesh.apps.cinehub.Model.Movie
import xcom.nitesh.apps.cinehub.data.repository.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movie : LiveData<List<Movie>> get() = _movies

    fun getUpcomingMoview() {
        viewModelScope.launch {
            val response = repository.getUpcomingMovies()
            _movies.postValue(response?.results)
        }
    }
}