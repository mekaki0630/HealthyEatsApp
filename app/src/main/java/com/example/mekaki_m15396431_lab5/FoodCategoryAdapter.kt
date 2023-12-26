package com.example.mekaki_m15396431_lab5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FoodCategoryAdapter(private val context: Context, private val names: List<String>, private val images: List<Int>) : BaseAdapter() {

    override fun getCount(): Int {
        return names.size
    }

    override fun getItem(position: Int): Any {
        return names[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val gridView: View

        if (convertView == null) {
            // If it's not recycled, initialize some attributes
            gridView = inflater.inflate(R.layout.grid_item_food_category, null)

            // Set the category name
            val categoryName = gridView.findViewById<TextView>(R.id.categoryName)
            categoryName.text = names[position]

            // Set the category image
            val categoryImage = gridView.findViewById<ImageView>(R.id.categoryImage)
            categoryImage.setImageResource(images[position])
        } else {
            gridView = convertView
        }

        return gridView
    }

}
