package com.example.egybest.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.movie_section.view.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent
import com.example.howtospeedtherecyclerview.R
import com.example.howtospeedtherecyclerview.ada.MovieAdapter
import com.example.howtospeedtherecyclerview.model.Movie
import com.example.howtospeedtherecyclerview.model.Sections

class SectionsAdapter(
    var c: Context,
    var s_l: ArrayList<Sections>,
    var m_l: ArrayList<Movie>,
    val s: Activity
) : RecyclerView.Adapter<SectionsAdapter.myHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val inflater = LayoutInflater.from(c).inflate(R.layout.movie_section, parent, false)
        return myHolder(inflater)
    }

    override fun getItemCount(): Int {
        return s_l.size
    }

    override fun onBindViewHolder(h: myHolder, p0: Int) {
        val i = s_l[p0]
        val mL = ArrayList<Movie>()
        h.s_name.text = i.name
        for (n in m_l) {
            if (n.movieSection == i.type) {
                mL += n
            }
        }
        h.s_rv.adapter = MovieAdapter(c, mL, s)
        val Y_BUFFER = 15
        var preX = 0f
        var preY = 0f

        h.s_rv.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(p0: RecyclerView, p1: MotionEvent) {

            }

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

                when (e.action) {

                    MotionEvent.ACTION_MOVE -> {
                        if (Math.abs(e.x - preX) > Math.abs(e.y - preY)) {
                            Log.e("if action_Move", e.x.toString())
                            rv.parent.requestDisallowInterceptTouchEvent(true)
                        } else if (Math.abs(e.y - preY) > Y_BUFFER) {
                            Log.e("else if action_Move", (Math.abs(e.y - preY)).toString())
                            rv.parent.requestDisallowInterceptTouchEvent(false)
                        }

                    }
                }
                preX = e.x
                preY = e.y
                Log.e("preX", (Math.abs(preX)).toString())
                Log.e("preY", (preY).toString())

                return false
            }

            override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {
            }
        })


        h.s_rv.layoutManager = LinearLayoutManager(c, RecyclerView.HORIZONTAL, false)

    }


    inner class myHolder(v: View) : RecyclerView.ViewHolder(v) {


        var s_name = v.tv_MovieSectionTitle
        var s_rv = v.rv_MovieSection
    }
}