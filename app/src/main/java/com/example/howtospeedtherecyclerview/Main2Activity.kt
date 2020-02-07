package com.example.howtospeedtherecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        customActionBar()


        val extra = intent.extras
        iv_movieImg.setImageResource(extra.getInt("image"))
        iv_moviPoster.setImageResource(extra.getInt("image"))
        tv_movieTitle.text = extra.getString("title")
    }


    fun customActionBar(): View {
        val actionBar = supportActionBar!!
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setCustomView(R.layout.custom_nav_bar)
        val view = actionBar.customView
        return view
    }
}
