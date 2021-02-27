package com.amrit.onebancassignment

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), CuisineAdapter.OnItemClickListener, View.OnClickListener,
        DishAdapter.SelectDishListener {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        setUI()
    }

    private fun setObserver() {
        mMainViewModel.getCartLiveData().observe(viewLifecycleOwner) { data -> updateUI(data) }
    }

    private fun updateUI(dishList: List<Dish>) {
        updateCount(dishList)
        val adapter = topThreeList.adapter as DishAdapter
        adapter.updateData(DataSource.topDishes)
        adapter.notifyDataSetChanged()
    }

    private fun updateCount(dishList: List<Dish>) {
        for (dish in DataSource.topDishes) {
            if (dishList.contains(dish)) {
                val index = dishList.indexOf(dish)
                val updateDish = dishList[index]
                dish.count = updateDish.count
            } else {
                dish.count = 0
            }
        }
    }

    private fun setUI() {
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(cuisineList)
        cuisineList.layoutManager =
                LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        (cuisineList.layoutManager as LinearLayoutManager).scrollToPosition(Int.MAX_VALUE / 2)
        cuisineList.adapter = CuisineAdapter(DataSource.cuisineList, this)

        topThreeList.layoutManager = LinearLayoutManager(mContext)
        topThreeList.adapter = DishAdapter(DataSource.topDishes, this)

        cartButton.setOnClickListener(this)
    }

    override fun onItemClick(cuisine: Cuisine) {
        mMainViewModel.setSelectedCuisine(cuisine)
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
        mMainViewModel.addDish(dish)
    }

    override fun onRemove(dish: Dish) {
        mMainViewModel.removeDish(dish)
    }

}