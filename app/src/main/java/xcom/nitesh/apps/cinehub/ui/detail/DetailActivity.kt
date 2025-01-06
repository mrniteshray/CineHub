package xcom.nitesh.apps.cinehub.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import xcom.nitesh.apps.cinehub.Model.Movie
import xcom.nitesh.apps.cinehub.R
import xcom.nitesh.apps.cinehub.databinding.ActivityDetailBinding
import xcom.nitesh.apps.cinehub.utils.Constants

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movielist = intent.getParcelableExtra<Movie>("movie")

        binding.titleTextView.text = movielist?.title
        binding.releaseYearTextView.text = movielist?.release_date
        binding.aboutMovieTextView.text = movielist?.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${movielist?.poster_path}")
            .into(binding.posterImageView)

        Glide.with(this)
            .load(Constants.ImageBaseURLw780+movielist?.backdrop_path)
            .into(binding.bannerImageView)

    }
}