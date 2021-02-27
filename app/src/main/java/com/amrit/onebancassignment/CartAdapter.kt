package com.amrit.onebancassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter(private val mDishList: List<Dish>) :
        RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dish: Dish) = with(itemView) {
            dishTitle.text = resources.getString(dish.name)
            quantity.text = dish.count.toString()
            price.text = dish.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
                mDishList[position]
        )
    }

    override fun getItemCount(): Int {
        return mDishList.size
    }

}