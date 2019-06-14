package app100.jain.com.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.new_layout.view.*

class MoviesAdapter(val movies: ArrayList<Movies>,val context: Context): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.new_layout,parent,false)
        val img=view.imageView
        val name=view.textView
        val aname=view.textView2
        name.text= movies[position].movieName+"("+movies[position].yearOfRelease+")"
        aname.text=movies[position].actorName
        img.setImageResource(movies[position].imageName)
        return view
    }

    override fun getItem(position: Int): Any {
        return movies.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

}