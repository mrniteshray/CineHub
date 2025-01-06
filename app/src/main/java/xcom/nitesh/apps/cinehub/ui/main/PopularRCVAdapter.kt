package xcom.nitesh.apps.cinehub.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xcom.nitesh.apps.cinehub.Model.Movie
import xcom.nitesh.apps.cinehub.R
import xcom.nitesh.apps.cinehub.utils.Constants

class PopularRCVAdapter(val context: Context, val movie : List<Movie>,val onclicked : (Movie) -> Unit) : RecyclerView.Adapter<PopularRCVAdapter.PopularViewHolder>() {
    class PopularViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val poster : ImageView = itemview.findViewById(R.id.movie_image)
        val name : TextView = itemview.findViewById(R.id.text_movie_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_home,parent,false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        var current = movie[position]
        holder.name.text = current.title
        Glide.with(context)
            .load(Constants.ImageBaseURLw500+current.poster_path)
            .into(holder.poster)

        holder.poster.setOnClickListener {
            onclicked(current)
        }
    }

}