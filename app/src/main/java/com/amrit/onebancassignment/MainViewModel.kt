package com.amrit.onebancassignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val selectedCuisine: MutableLiveData<Cuisine> = MutableLiveData()
    private val cartLiveData: MutableLiveData<MutableList<Dish>> = MutableLiveData()
    private val cartData: MutableList<Dish> = mutableListOf()

    fun setSelectedCuisine(cuisine: Cuisine) {
        selectedCuisine.value = cuisine
    }

    fun getSelectedCuisine() = selectedCuisine

    fun addDish(dish: Dish) {
        if (cartData.contains(dish)) {
            val index = cartData.indexOf(dish)
            cartData[index].count = cartData[index].count.plus(1)
        } else {
            dish.count = 1
            cartData.add(dish)
        }
        cartLiveData.value = cartData
    }

    fun removeDish(dish: Dish) {
        if (cartData.contains(dish)) {
            val index = cartData.indexOf(dish)
            if (cartData[index].count == 1) {
                cartData.removeAt(index)
            } else {
                cartData[index].count = cartData[index].count.plus(-1)
            }
        }
        cartLiveData.value = cartData
    }

    fun getCartLiveData() = cartLiveData

}