package xcom.nitesh.apps.cinehub.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
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

        addGenresToChipGroup(binding.genreChipGroup, movielist?.genre_ids!!)
    }
    private fun addGenresToChipGroup(chipGroup: ChipGroup, genreIds: List<Int>) {
        val genreMap = hashMapOf(
            28 to "Action 🤠", 12 to "Adventure 🏕", 16 to "Animation 🎥",
            35 to "Comedy 🤣", 80 to "Crime 👮‍♂️", 99 to "Documentary 📃",
            18 to "Drama 😨", 10751 to "Family 👪", 14 to "Fantasy 🧙‍♂️",
            36 to "History 💾", 27 to "Horror 👻", 10402 to "Music 🎶",
            9648 to "Mystery 🕵️‍♀️", 10749 to "Romance 💏", 878 to "Sci-Fi 🚀",
            53 to "Thriller 🗡", 10752 to "War ⚔", 37 to "Western 🤵",
            10770 to "TV Movie 📺"
        )

        genreIds.forEach { genreId ->
            genreMap[genreId]?.let { genreName ->
                val chip = Chip(chipGroup.context).apply {
                    text = genreName
                    isCheckable = false
                    isClickable = false
                    setChipBackgroundColorResource(android.R.color.black)
                    setTextColor(resources.getColor(android.R.color.white, null))
                }
                chipGroup.addView(chip)
            }
        }
    }
}