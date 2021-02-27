package com.amrit.onebancassignment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dish.*


class DishFragment : Fragment(), View.OnClickListener, DishAdapter.SelectDishListener {

    private val mMainViewModel: MainViewModel by activityViewModels()
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartButton.setOnClickListener(this)
        setObserver()
    }

    private fun setObserver() {
        mMainViewModel.getSelectedCuisine().observe(viewLifecycleOwner) { cuisine -> setUI(cuisine) }
        mMainViewModel.getCartLiveData().observe(viewLifecycleOwner) { data -> updateUI(data) }
    }

    private fun setUI(cuisine: Cuisine) {
        cuisineTitle.text = resources.getString(cuisine.name)
        cuisineDishList.layoutManager = LinearLayoutManager(mContext)
        val dishList: List<Dish> = when (cuisine.name) {
            R.string.txt_north -> DataSource.northIndian
            R.string.txt_chinese -> DataSource.chinese
            R.string.txt_south -> DataSource.southIndian
            R.string.txt_italian -> DataSource.italian
            else -> DataSource.northIndian
        }
        cuisineDishList.adapter = DishAdapter(dishList, this)
        mMainViewModel.selectedCuisineData = dishList
    }

    private fun updateUI(cartDishList: List<Dish>) {
        val dishList = mMainViewModel.selectedCuisineData
        for (dish in dishList) {
            if (cartDishList.contains(dish)) {
                val index = cartDishList.indexOf(dish)
                val updateDish = cartDishList[index]
                dish.count = updateDish.count
            } else {
                dish.count = 0
            }
        }
        val adapter = cuisineDishList.adapter as DishAdapter?
        if (adapter != null) {
            adapter.updateData(dishList)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onClick(v: View?) {
        val action =
                DishFragmentDirections
                        .actionCuisineFragmentToCartFragment()
        view?.findNavController()?.navigate(action)
    }

    override fun onAdd(dish: Dish) {
        mMainViewModel.addDish(dish)
    }

    override fun onRemove(dish: Dish) {
        mMainViewModel.removeDish(dish)
    }

}