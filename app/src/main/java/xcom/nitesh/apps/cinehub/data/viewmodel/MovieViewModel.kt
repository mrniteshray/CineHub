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

    private val _popularmovies = MutableLiveData<List<Movie>>()
    val popularmovie : LiveData<List<Movie>> get() = _popularmovies

    private val _topratedmovies = MutableLiveData<List<Movie>>()
    val topratedmovie : LiveData<List<Movie>> get() = _topratedmovies



    fun getUpcomingMoview() {
        viewModelScope.launch {
            val response = repository.getUpcomingMovies()
            _movies.postValue(response?.results)
        }
    }

    fun getPopularMovie() {
        viewModelScope.launch {
            val response = repository.getPopularMovies()
            _popularmovies.postValue(response?.results)
        }
    }

    fun getTopRatedMovie() {
        viewModelScope.launch {
            val response = repository.getTopRatedMovies()
            _topratedmovies.postValue(response?.results)
        }
    }
}