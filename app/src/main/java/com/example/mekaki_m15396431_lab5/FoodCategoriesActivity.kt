package com.example.mekaki_m15396431_lab5

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity


class FoodCategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_categories)

        val foodGridView = findViewById<GridView>(R.id.gridView)

        val nameList = ArrayList<String>()
        val imageList = ArrayList<Int>()

        nameList.add("Burritos")
        imageList.add(R.drawable.burritos)
        nameList.add("Asian Fusion")
        imageList.add(R.drawable.asianfusion)
        nameList.add("Indian Curry")
        imageList.add(R.drawable.indiancurry)
        nameList.add("Juice and Smoothies")
        imageList.add(R.drawable.juiceandsmoothies)
        nameList.add("New Mexican")
        imageList.add(R.drawable.newmexican)
        nameList.add("Northern Thai")
        imageList.add(R.drawable.nothernthai)
        nameList.add("Vegetarian")
        imageList.add(R.drawable.vegetarian)
        nameList.add("West Indian")
        imageList.add(R.drawable.westindian)
        nameList.add("Vegetarian Friendly")
        imageList.add(R.drawable.vegetarianfriendly)
        nameList.add("Colombian")
        imageList.add(R.drawable.colombian)


        // Set up a custom adapter to display the grid items
        val adapter = FoodCategoryAdapter(this, nameList, imageList)
        foodGridView.adapter = adapter

        // Set item click listener to navigate to the next activity
        foodGridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedCategory = nameList[position]
            // Implement an Intent to navigate to the next activity with the selected category data
            val intent = Intent(this, FoodItemsActivity::class.java)
            intent.putExtra("selectedCategory", selectedCategory)
            startActivity(intent)

        }
    }
}
