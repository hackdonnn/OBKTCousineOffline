package com.amrit.onebancassignment

object DataSource {

    val cuisineList = listOf(
            Cuisine(R.drawable.ic_food, R.string.txt_north),
            Cuisine(R.drawable.ic_food, R.string.txt_chinese),
            Cuisine(R.drawable.ic_food, R.string.txt_south),
            Cuisine(R.drawable.ic_food, R.string.txt_italian)
    )

    val topDishes = mutableListOf(
            Dish(R.drawable.ic_food, R.string.txt_paratha, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_pizza, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_fried, 100, 4.5)
    )

    val northIndian = mutableListOf(
            Dish(R.drawable.ic_food, R.string.txt_dal, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_panner, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_chapti, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_paratha, 100, 4.5)
    )

    val chinese = mutableListOf(
            Dish(R.drawable.ic_food, R.string.txt_noodles, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_chilly, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_fried, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_momos, 100, 4.5)
    )

    val southIndian = mutableListOf(
            Dish(R.drawable.ic_food, R.string.txt_dosa, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_idli, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_masala_dosa, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_panner_dosa, 200, 4.5)
    )

    val italian = mutableListOf(
            Dish(R.drawable.ic_food, R.string.txt_pizza, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_pasta, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_white_pasta, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_red_pasta, 200, 4.5)
    )

}