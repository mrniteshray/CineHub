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

class UpcomingRCVAdapter(val context: Context, val movie : List<Movie>, val onClick : (Movie) -> Unit) : RecyclerView.Adapter<UpcomingRCVAdapter.UpcomingViewHolder>() {

    class UpcomingViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val imageView : ImageView = itemview.findViewById(R.id.upcoming_image)
        val textView : TextView = itemview.findViewById(R.id.upcomingMoviename)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming,parent,false)
        return UpcomingViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        var current = movie[position]
        Glide.with(context)
            .load(Constants.ImageBaseURLw780+current.backdrop_path)
            .into(holder.imageView)
        holder.textView.text = current.title

        holder.itemView.setOnClickListener {
            onClick(current)
        }
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}