package com.amrit.onebancassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cuisine_list_item.view.*

class CuisineAdapter(
        private val cuisineList: List<Cuisine>,
        private val mClickListener: OnItemClickListener
) :
        RecyclerView.Adapter<CuisineAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(cuisine: Cuisine)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cuisine: Cuisine, listener: OnItemClickListener) = with(itemView) {
            cuisineItemImage.setImageResource(cuisine.image)
            cuisineItemTitle.text = resources.getString(cuisine.name)
            itemView.setOnClickListener { listener.onItemClick(cuisine) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cuisine_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cuisineList[position], mClickListener)
    }

    override fun getItemCount(): Int {
        return cuisineList.size
    }

}