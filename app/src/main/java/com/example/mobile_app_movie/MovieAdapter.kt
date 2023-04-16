package com.example.mobile_app_movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_movie.databinding.MoviesListLayoutBinding
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList: MutableList<Movie>, private val context: Context, private val listener: OnClick):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val recyclerItemMoviePopularCompleteBinding: MoviesListLayoutBinding =
            MoviesListLayoutBinding.inflate(layoutInflater, parent, false)
        return TypeItem(recyclerItemMoviePopularCompleteBinding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = movieList[position]
        if (holder is TypeItem) {
            holder.binding(movie)
            holder.itemView.setOnClickListener {
                listener.onClick(movie.id)
            }
        }
    }

    inner class TypeItem(private val recyclerItem: MoviesListLayoutBinding):
        RecyclerView.ViewHolder(recyclerItem.root) {
            fun binding(movie: Movie) {
                Picasso.get().load(movie.image).into(recyclerItem.movieBackground)
                recyclerItem.movieName.text = movie.name
            }
        }
}

interface OnClick{
    fun onClick(id: Int)
}