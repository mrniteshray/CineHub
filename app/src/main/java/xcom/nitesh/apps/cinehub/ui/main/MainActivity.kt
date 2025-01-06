package xcom.nitesh.apps.cinehub.ui.main

import android.os.Bundle
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
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var movieViewModel: MovieViewModel

    lateinit var upcomingRCVAdapter : UpcomingRCVAdapter
    lateinit var movielist : List<Movie>
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


        movieViewModel.getUpcomingMoview()

        movieViewModel.movie.observe(this, Observer {
            movielist = it
            upcomingRCVAdapter = UpcomingRCVAdapter(this,movielist)
            binding.recyclerViewUpcoming.adapter = upcomingRCVAdapter
        })


    }
}