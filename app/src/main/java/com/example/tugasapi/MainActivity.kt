package com.example.tugasapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasapi.api.ApiConfig
import com.example.tugasapi.model.ResponseRecipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rvRecipe = findViewById<RecyclerView>(R.id.rv_recipe)

        ApiConfig.getService().getRecipes().enqueue(object :
            Callback<ResponseRecipe> {
            override fun onResponse(
                call: Call<ResponseRecipe>,
                response: Response<ResponseRecipe>
            ) {
                if (response.isSuccessful) {
                    val responseRecipe = response.body()
                    val dataRecipe = responseRecipe?.results
                    val recipeAdapter = RecipeAdapter(dataRecipe)
                    rvRecipe.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        recipeAdapter.notifyDataSetChanged()
                        adapter = recipeAdapter
                    }

                }
            }

            override fun onFailure(call: Call<ResponseRecipe>, t: Throwable) {
                Log.d("MainActivity", "error di " + t.localizedMessage)
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()

            }

        })

    }
}