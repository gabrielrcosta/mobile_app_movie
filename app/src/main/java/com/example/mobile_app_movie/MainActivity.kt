package com.example.mobile_app_movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_app_movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = MovieAdapter(getMovies(), this, goToMovieDetails())
        binding.recyclerView.adapter = movieAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun goToMovieDetails(): OnClick{
        return object: OnClick{
            override fun onClick(id: Int) {
                val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
                intent.putExtra("Movies", id)
                startActivity(intent)
            }
        }
    }
}