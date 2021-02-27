package com.amrit.onebancassignment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), CuisineAdapter.OnItemClickListener, View.OnClickListener,
        DishesAdapter.SelectDishListener {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
    }

    private fun setUI() {
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(cuisineList)
        cuisineList.layoutManager =
                LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        cuisineList.adapter = CuisineAdapter(DataSource.cuisineList, this)

        topThreeList.layoutManager = LinearLayoutManager(mContext)
        topThreeList.adapter = DishesAdapter(DataSource.topDishes, this)

        cartButton.setOnClickListener(this)
    }

    override fun onItemClick(cuisine: Cuisine) {
        mainViewModel.setSelectedCuisine(cuisine)
        val action =
                HomeFragmentDirections
                        .actionHomeFragmentToCuisineFragment()
        view?.findNavController()?.navigate(action)
    }

    override fun onClick(v: View?) {
        val action =
                HomeFragmentDirections
                        .actionHomeFragmentToCartFragment()
        view?.findNavController()?.navigate(action)
    }

    override fun onAdd(dish: Dish) {
        Toast.makeText(mContext, resources.getString(R.string.txt_item_added), Toast.LENGTH_SHORT).show()
        mainViewModel.addDish(dish)
    }

    override fun onRemove(dish: Dish) {
        Toast.makeText(mContext, resources.getString(R.string.txt_item_removed), Toast.LENGTH_SHORT).show()
        mainViewModel.removeDish(dish)
    }

}