package com.example.car_project

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListCarAdapter(private val listCar: ArrayList<Car>) : RecyclerView.Adapter<ListCarAdapter.ListViewHolder>() {


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item)
        val name: TextView = itemView.findViewById(R.id.item_name)
        val description:TextView = itemView.findViewById(R.id.tv_item_description)
      // val spesification:TextView = itemView.findViewById(R.id.tv_item_spec)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_car,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (names,description,photo,spec) = listCar[position]
        holder.imgPhoto.setImageResource(photo)
        holder.name.text = names
        holder.description.text = description
        //holder.spesification.text = spec

        holder.itemView.setOnClickListener {
            val model = listCar[position]
            var title : String = model.name
            var desc : String = model.description
            var spec : String = model.specification
            var photo: Int = model.photo

            val  intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("names",title)
            intent.putExtra("descrip",desc)
            intent.putExtra("speci",spec)
            intent.putExtra("foto",photo)
            holder.itemView.context.startActivities(arrayOf(intent))
        }

    }

    override fun getItemCount(): Int = listCar.size
}