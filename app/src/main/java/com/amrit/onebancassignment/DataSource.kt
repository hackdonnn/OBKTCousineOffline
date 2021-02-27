package com.amrit.onebancassignment

object DataSource {

    val cuisineList = listOf(
            Cuisine(R.drawable.ic_food, R.string.txt_north),
            Cuisine(R.drawable.ic_food, R.string.txt_chinese),
            Cuisine(R.drawable.ic_food, R.string.txt_south),
            Cuisine(R.drawable.ic_food, R.string.txt_italian)
    )

    val topDishes = mutableListOf<Dish>(
            Dish(R.drawable.ic_food, R.string.txt_paratha, 100, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_pizza, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_fried, 300, 4.5)
    )

    val northIndian = listOf<Dish>(
            Dish(R.drawable.ic_food, R.string.txt_dal, 80, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_panner, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_chapti, 20, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_paratha, 20, 4.5)
    )

    val chinese = listOf<Dish>(
            Dish(R.drawable.ic_food, R.string.txt_noodles, 80, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_chilly, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_fried, 20, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_momos, 20, 4.5)
    )

    val southIndian = listOf<Dish>(
            Dish(R.drawable.ic_food, R.string.txt_dosa, 80, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_idli, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_masala_dosa, 20, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_panner_dosa, 20, 4.5)
    )

    val italian = listOf<Dish>(
            Dish(R.drawable.ic_food, R.string.txt_pizza, 80, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_pasta, 200, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_white_pasta, 20, 4.5),
            Dish(R.drawable.ic_food, R.string.txt_red_pasta, 20, 4.5)
    )

}