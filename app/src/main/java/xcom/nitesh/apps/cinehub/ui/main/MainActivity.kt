package xcom.nitesh.apps.cinehub.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import xcom.nitesh.apps.cinehub.Model.Movie
import xcom.nitesh.apps.cinehub.R
import xcom.nitesh.apps.cinehub.data.viewmodel.MovieViewModel
import xcom.nitesh.apps.cinehub.databinding.ActivityMainBinding
import xcom.nitesh.apps.cinehub.ui.detail.DetailActivity
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var movieViewModel: MovieViewModel

    private lateinit var upcomingRCVAdapter : UpcomingRCVAdapter
    private lateinit var movielist : List<Movie>

    private lateinit var popularRCVAdapter : PopularRCVAdapter
    private lateinit var topratedRCVAdapter : TopRCVAdapter
    private lateinit var popularmoviewlist : List<Movie>
    private lateinit var topratedmoviewlist : List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recyclerViewUpcoming.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewToprated.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)


        movieViewModel.getUpcomingMoview()
        movieViewModel.getPopularMovie()
        movieViewModel.getTopRatedMovie()

        movieViewModel.movie.observe(this, Observer {
            movielist = it
            upcomingRCVAdapter = UpcomingRCVAdapter(this,movielist){
                movie ->
                startDetailActivity(movie)
            }
            binding.recyclerViewUpcoming.adapter = upcomingRCVAdapter
        })

        movieViewModel.popularmovie.observe(this, Observer {
            popularmoviewlist = it
            popularRCVAdapter = PopularRCVAdapter(this,popularmoviewlist){
                movie ->
                startDetailActivity(movie)
            }
            binding.recyclerViewPopular.adapter = popularRCVAdapter
        })

        movieViewModel.topratedmovie.observe(this, Observer {
            topratedmoviewlist = it
            topratedRCVAdapter = TopRCVAdapter(this,topratedmoviewlist){
                movie ->
                startDetailActivity(movie)
            }
            binding.progressBar.visibility = View.GONE
            binding.textPopular.visibility = View.VISIBLE
            binding.toprated.visibility = View.VISIBLE
            binding.textUpcoming.visibility = View.VISIBLE
            binding.recyclerViewToprated.adapter = topratedRCVAdapter
        })
    }

    private fun startDetailActivity(movie : Movie){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("movie",movie)
        startActivity(intent)
    }
}