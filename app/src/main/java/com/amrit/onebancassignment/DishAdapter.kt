package com.amrit.onebancassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dish_list_item.view.*

class DishAdapter(
        private var mDishList: List<Dish>,
        private val mSelectDishListener: SelectDishListener
) :
        RecyclerView.Adapter<DishAdapter.ViewHolder>() {

    interface SelectDishListener {
        fun onAdd(dish: Dish)
        fun onRemove(dish: Dish)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dish: Dish, selectDishListener: SelectDishListener) = with(itemView) {
            dishItemImage.setImageResource(dish.image)
            dishItemTitle.text = resources.getString(dish.name)
            dishItemPrice.text =
                    String.format(resources.getString(R.string.template_price), dish.price)
            dishItemRating.text =
                    String.format(resources.getString(R.string.template_rating), dish.rating)
            dishCount.text = dish.count.toString()
            add.setOnClickListener { selectDishListener.onAdd(dish) }
            remove.setOnClickListener { selectDishListener.onRemove(dish) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.dish_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
                mDishList[position], mSelectDishListener
        )
    }

    override fun getItemCount(): Int {
        return mDishList.size
    }

    fun updateData(dishList: List<Dish>) {
        mDishList = dishList
    }

}