package com.example.mobile_app_movie

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_app_movie.databinding.ActivityMainBinding
import com.example.mobile_app_movie.databinding.MoviesInfoLayoutBinding
import com.squareup.picasso.Picasso

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: MoviesInfoLayoutBinding
    private var movieId: Int = 5
    private var movieDetail: Movie?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoviesInfoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
            movieId = intent.getIntExtra("Movies", 5)
            movieDetail = getMovie(movieId)
            movieDetail?.let {
                binding.apply {
                    Picasso.get().load(it.image).into(moviePic)
                    movieName.text = it.name
                    movieInformation.text = it.description
                    Picasso.get().load(it.certification).into(certificationIcon)
                    cast.text = it.starring.toString().removePrefix("[").removeSuffix("]")
                    timer.text = it.running_time_min.toString()
                    seatsNumber.text = it.seats_remaining.toString()
                }
            }
    }
}