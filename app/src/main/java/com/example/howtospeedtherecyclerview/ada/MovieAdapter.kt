package com.example.howtospeedtherecyclerview.ada

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.howtospeedtherecyclerview.Main2Activity
import com.example.howtospeedtherecyclerview.R
import com.example.howtospeedtherecyclerview.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(var c: Context, var list: ArrayList<Movie>, val s: Activity) :
    RecyclerView.Adapter<MovieAdapter.myView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myView {
        val inflate = LayoutInflater.from(c).inflate(R.layout.movie_item, parent, false)
        return myView(inflate)
    }

    override fun getItemCount(): Int {
        if (list.size < 10) {
            return list.size
        } else {
            return 10
        }
    }

    override fun onBindViewHolder(holder: myView, position: Int) {

        val title = holder.itemView.tv_movieTitle
        val image = holder.itemView.iv_movieImg

        title.text = list[position].title
        Picasso.get().load(list[position].image!!).into(image)
        image.transitionName = "imageShared"
        holder.itemView.setOnClickListener {
            val intent = Intent(c, Main2Activity::class.java).apply {
                putExtra("image", list[position].image)
                putExtra("title", list[position].title)
            }

            val op = ActivityOptions.makeSceneTransitionAnimation(
                s,
                holder.itemView.iv_movieImg,
                "imageShared"
            )
            c.startActivity(intent, op.toBundle())
        }


    }


    inner class myView(itemView: View) : RecyclerView.ViewHolder(itemView)
}