package com.example.mekaki_m15396431_lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val continueButton = findViewById<Button>(R.id.continueButton)

        continueButton.setOnClickListener {
            // Handle "Continue" button click, navigate to Activity 2: Food Categories List
            val intent = Intent(this@HomeActivity, FoodCategoriesActivity::class.java)
            startActivity(intent)
        }
    }
}