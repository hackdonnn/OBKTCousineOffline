package com.amrit.onebancassignment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cuisine.*

class CuisineFragment : Fragment(), View.OnClickListener, DishesAdapter.SelectDishListener {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cuisine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartButton.setOnClickListener(this)
        setObserver()
    }

    private fun setObserver() {
        mainViewModel.getSelectedCuisine().observe(viewLifecycleOwner) { cuisine -> setUI(cuisine) }
    }

    private fun setUI(cuisine: Cuisine) {
        cuisineTitle.text = resources.getString(cuisine.name)
        cuisineDishList.layoutManager = LinearLayoutManager(mContext)
        val adapter: DishesAdapter = when (cuisine.name) {
            R.string.txt_north -> DishesAdapter(DataSource.northIndian, this)
            R.string.txt_chinese -> DishesAdapter(DataSource.chinese, this)
            R.string.txt_south -> DishesAdapter(DataSource.southIndian, this)
            R.string.txt_italian -> DishesAdapter(DataSource.italian, this)
            else -> DishesAdapter(DataSource.northIndian, this)
        }
        cuisineDishList.adapter = adapter
    }

    override fun onClick(v: View?) {
        val action =
                CuisineFragmentDirections
                        .actionCuisineFragmentToCartFragment()
        view?.findNavController()?.navigate(action)
    }

    override fun onAdd(dish: Dish) {
        Toast.makeText(mContext,resources.getString(R.string.txt_item_added), Toast.LENGTH_SHORT).show()
        mainViewModel.addDish(dish)
    }

    override fun onRemove(dish: Dish) {
        Toast.makeText(mContext,resources.getString(R.string.txt_item_removed),Toast.LENGTH_SHORT).show()
        mainViewModel.removeDish(dish)
    }

}