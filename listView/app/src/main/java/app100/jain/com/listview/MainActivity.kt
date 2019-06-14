package app100.jain.com.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    val movies= arrayOf("Iron Man","The Incredible Hulk","Caption America: The First Avenger","Iron Man 2","Thor","Iron Man 3","Captain America: The Winter Soldier","The Avengers","Thor: The Dark World","Avengers: Age of Ultron")
    val actors= arrayOf("Robert Downey Jr.","BB","Chris Evans","Robert Downey Jr.","Chris Hemsworth","Robert Downey Jr.","Chris Evans","Everyone","Chris Hemsworth","Everyone")
    var Images= arrayOf(R.drawable.im,R.drawable.tih,R.drawable.catfa,R.drawable.im2,R.drawable.t,R.drawable.im3,R.drawable.catws,R.drawable.tv,R.drawable.thorthedarkworld,R.drawable.ageofultron)
    val releaseDate= arrayOf(2008,2009,2011,2010,2009,2011,2013,2012,2014,2015)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list:ArrayList<Movies> = arrayListOf()
        for (i in movies.indices){
            list?.add(Movies(
                movieName = movies[i],
                actorName = actors[i],
                imageName = Images[i],
                yearOfRelease = releaseDate[i]))
        }
        val adapter= MoviesAdapter(list!!,this)
//        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,movies)
        listView.adapter=adapter
    }
}
