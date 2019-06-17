package app100.jain.com.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.new_view.view.*

class MoviesAdapter(val moviesList: ArrayList<Movies>, val context: Context): RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater= LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.new_view,parent,false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
       val movie=moviesList[position]
        holder.itemView.apply {
            textView.text=movie.movieName
            textView.text=movie.actorName
            imageView.setImageResource(movie.imageName)
        }
    }

}
class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)