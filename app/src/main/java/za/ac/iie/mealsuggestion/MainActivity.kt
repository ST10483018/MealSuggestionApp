package za.ac.iie.mealsuggestion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // UI Elements
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTimeOfDay)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val txtSuggestion = findViewById<TextView>(R.id.txtSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // Meal suggestion logic using IF statements
        btnSuggest.setOnClickListener {
            val timeOfDay = edtTimeOfDay.text.toString()
            var mealSuggestion = ""

            if (timeOfDay == "morning") {
                mealSuggestion = "Breakfast: Cereal"
            } else if (timeOfDay == "mid morning") {
                mealSuggestion = "Snack: Snack Bar"
            } else if (timeOfDay == "afternoon"){
                mealSuggestion = "Lunch: Burger"
            } else if (timeOfDay == "mid afternoon"){
                mealSuggestion = "Snack: Sweets"
            } else if (timeOfDay == "dinner") {
                mealSuggestion = "Main Course: Steak & Mash"
            } else if (timeOfDay == "after dinner") {
                mealSuggestion = "Dessert: Malva Pudding"
            } else {
                mealSuggestion = "Invalid input! Please enter a valid time of day (e.g., Morning, Afternoon, Dinner)."
            }

            txtSuggestion.text = mealSuggestion
        }

        //Reset button functionality
        btnReset.setOnClickListener {
            edtTimeOfDay.text.clear()
            txtSuggestion.text =""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}