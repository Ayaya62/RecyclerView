package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapterRestaurant = RestaurantAdapter(generaterestaurants()){
            restaurant -> Toast.makeText(this@MainActivity, "Hei! You Clicked on ${restaurant.name}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvRestaurant.apply {
                adapter = adapterRestaurant
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generaterestaurants() : List<Restaurant>{
        return listOf(
            Restaurant( name = "McDonalds", type = "Western"),
            Restaurant( name = "Bornga", type = "Korean"),
            Restaurant( name = "Sushi Tei", type = "Japanese",),
            Restaurant( name = "Mas Kobis", type = "Javanese"),
            Restaurant( name = "Leko", type = "Indonesian")
        )
    }
}