package com.example.howtospeedtherecyclerview


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.AnimationUtils
import com.example.egybest.adapter.SectionsAdapter
import com.example.howtospeedtherecyclerview.model.Movie
import com.example.howtospeedtherecyclerview.model.Sections
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_nav_bar.view.*

class MainActivity : AppCompatActivity() {

    val mL = ArrayList<Movie>()
    val sL = ArrayList<Sections>()


    var menuState = 0

    val pop = "popular"
    val new = "new movie"
    val newB = "new movie blueRay"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = customActionBar()

        view.menu.setOnClickListener {
            if (menuState == 0) {
                menu_drawable.visibility = View.VISIBLE
                menu_drawable.animation = AnimationUtils.loadAnimation(this, R.anim.menu_slider)
                menuState = 1
            } else {
                menu_drawable.visibility = View.GONE
                menu_drawable.animation =
                    AnimationUtils.loadAnimation(this, R.anim.menu_slider_close)
                menuState = 0
            }
        }

        dataBaseTest()

        sectionBseTest()

        val r = Handler()
        val ru = Runnable {
            val Adapter = SectionsAdapter(this, sL, mL, this)
            rv_MovieSectionHolder.adapter = Adapter
            rv_MovieSectionHolder.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        }
        r.postDelayed(ru, 100)


    }


    fun sectionBseTest() {
        sL += Sections(resources.getString(R.string.popular_movie), pop)
        sL += Sections(resources.getString(R.string.new_movie), new)
        sL += Sections(resources.getString(R.string.new_movie_bluRay), pop)


    }

    fun dataBaseTest() {
        mL += Movie("البدلة (2018)", R.drawable.elbadla, pop)
        mL += Movie("Fast & Furious Presents: Hobbs & Shaw (2019)", R.drawable.fastandfuious, pop)
        mL += Movie("Avengers: Endgame (2019)", R.drawable.avengers, pop)
        mL += Movie("John Wick: Chapter 3 - Parabellum (2019)", R.drawable.jhon, pop)
        mL += Movie("Spider-Man: Far from Home (2019)", R.drawable.spiderman, pop)
        mL += Movie("ولاد رزق (2015)", R.drawable.rezk, pop)
        mL += Movie("حرب كرموز (2018)", R.drawable.karmoz, pop)


        mL += Movie("American Factory (2019)", R.drawable.ame, new)
        mL += Movie("Hoax (2019)", R.drawable.hox, new)
        mL += Movie("Tone-Deaf (2019)", R.drawable.tone2, new)
        mL += Movie("The Tomorrow Man (2019)", R.drawable.tommo, new)
        mL += Movie("Seaside (2018)", R.drawable.sa, new)
        mL += Movie("Jacob's Ladder (2019)", R.drawable.jac, new)
        mL += Movie("Hot Air (2018)", R.drawable.hot, new)
        mL += Movie("Skin (2018)", R.drawable.skin, new)
    }


    fun customActionBar(): View {
        val actionBar = supportActionBar!!
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setCustomView(R.layout.custom_nav_bar)
        val view = actionBar.customView
        return view
    }

    override fun onBackPressed() {
        if (menuState == 1) {
            menu_drawable.visibility = View.GONE
            menu_drawable.animation = AnimationUtils.loadAnimation(this, R.anim.menu_slider_close)
            menuState = 0
        } else {
            super.onBackPressed()
        }

    }

}


