package com.example.mekaki_m15396431_lab5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class FoodItemsActivity : AppCompatActivity() {

    lateinit var numOfFoodItems: TextView
    lateinit var incButton: Button
    lateinit var decButton: Button
    lateinit var toggleImage: ToggleButton
    lateinit var foodMenuImage: ImageView
    lateinit var submitFoodDetails: Button
    lateinit var displayOfFoodSelectionDetails: TextView
    lateinit var allergyRequestInfo : EditText


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_items)

        numOfFoodItems = findViewById(R.id.ItemCountLabel)
        incButton = findViewById(R.id.increase)
        decButton = findViewById(R.id.decrease)
        var tempcounter: Int = 0

        incButton.setOnClickListener{
            tempcounter++
            numOfFoodItems.setText(tempcounter.toString())
        }
        decButton.setOnClickListener{
            tempcounter--
            numOfFoodItems.setText(tempcounter.toString())
        }

        toggleImage =  findViewById(R.id.toggleId)
        foodMenuImage =  findViewById(R.id.FoodMenuImageId)

        toggleImage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //show the food menu image
                foodMenuImage.visibility = ImageView.VISIBLE
            } else {
                //hide the food menu image
                foodMenuImage.visibility = ImageView.GONE
            }
        }

        submitFoodDetails = findViewById(R.id.submitButton)
        displayOfFoodSelectionDetails = findViewById(R.id.displayFoodSelectedDetails)
        allergyRequestInfo = findViewById(R.id.allergyRequestTextView)

        submitFoodDetails.setOnClickListener {
            val foodItemCount = numOfFoodItems.text.toString().toInt()

            val inputSummary = when {
                foodItemCount <= 0 -> "No food items selected"
                foodItemCount > 0 && allergyRequestInfo.text.isNotEmpty() ->
                    "$foodItemCount Food Item Details with special allergy request information: ${allergyRequestInfo.text} Successfully Submitted."
                else -> "$foodItemCount Food Item Details Successfully Submitted."
            }

            displayOfFoodSelectionDetails.text = inputSummary
        }

    }
}