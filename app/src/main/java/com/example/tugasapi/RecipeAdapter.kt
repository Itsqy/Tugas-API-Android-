package com.example.tugasapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasapi.model.ResultsItem

class RecipeAdapter(val dataRecipe: List<ResultsItem?>?) :
    RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgRecipe = view.findViewById<ImageView>(R.id.item_image_recipe)
        val tvTitle = view.findViewById<TextView>(R.id.item_tv_title)
        val tvPorsi = view.findViewById<TextView>(R.id.item_tv_portion)
        val tvDurasi = view.findViewById<TextView>(R.id.item_tv_times)
        val tvDificulty = view.findViewById<TextView>(R.id.item_tv_dificulty)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_recipe, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvDurasi.text = dataRecipe?.get(position)?.times
        holder.tvTitle.text = dataRecipe?.get(position)?.title
        holder.tvPorsi.text = dataRecipe?.get(position)?.portion
        holder.tvDificulty.text = dataRecipe?.get(position)?.dificulty

        Glide.with(holder.itemView)
            .load(dataRecipe?.get(position)?.thumb)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRecipe)

    }

    override fun getItemCount(): Int {
        if (dataRecipe != null) {
            return dataRecipe.size

        }

        return 0
    }

}