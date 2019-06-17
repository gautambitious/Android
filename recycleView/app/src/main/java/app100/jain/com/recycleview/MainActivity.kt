package app100.jain.com.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val movies= arrayOf("Iron Man","The Incredible Hulk","Caption America: The First Avenger","Iron Man 2","Thor","Iron Man 3","Captain America: The Winter Soldier","The Avengers","Thor: The Dark World","Avengers: Age of Ultron")
    val actors= arrayOf("Robert Downey Jr.","BB","Chris Evans","Robert Downey Jr.","Chris Hemsworth","Robert Downey Jr.","Chris Evans","Everyone","Chris Hemsworth","Everyone")
    var Images= arrayOf(R.drawable.im,R.drawable.tih,R.drawable.catfa,R.drawable.im2,R.drawable.t,R.drawable.im3,R.drawable.catws,R.drawable.tv,R.drawable.thorthedarkworld,R.drawable.ageofultron)
    val releaseDate= arrayOf(2008,2009,2011,2010,2009,2011,2013,2012,2014,2015)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list:ArrayList<Movies> = arrayListOf()
        for (j in 0..99){
            val i= Random.nextInt(10)
            list.add(Movies(
                movieName = movies[i],
                actorName = actors[i],
                imageName = Images[i],
                yearOfRelease = releaseDate[i]))
        }
        rvMovies.layoutManager=GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false)
        rvMovies.adapter=MoviesAdapter(list,this)
    }
}
