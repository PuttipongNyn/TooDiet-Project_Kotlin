package com.example.diet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import com.example.diet.Exercise.ExerciseListShow
import com.example.diet.FoodList.FoodListShow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()

        var btnLogo1 = findViewById<RelativeLayout>(R.id.logo1)
        var btnRow1 = findViewById<RelativeLayout>(R.id.Row1)
        var btnLogo2 = findViewById<RelativeLayout>(R.id.logo2)
        var btnRow2 = findViewById<RelativeLayout>(R.id.Row2)
        var btnLogo3 = findViewById<RelativeLayout>(R.id.logo3)
        var btnRow3 = findViewById<RelativeLayout>(R.id.Row3)
        var btnLogo4 = findViewById<RelativeLayout>(R.id.logo4)
        var btnRow4 = findViewById<RelativeLayout>(R.id.Row4)


        btnLogo1.setOnClickListener {
            val intent = Intent(this, FoodListShow::class.java)
            startActivity(intent)
        }

        btnRow1.setOnClickListener {
            val intent = Intent(this, FoodListShow::class.java)
            startActivity(intent)
        }

        btnLogo2.setOnClickListener {
            val intent = Intent(this, ExerciseListShow::class.java)
            startActivity(intent)
        }

        btnRow2.setOnClickListener {
            val intent = Intent(this, ExerciseListShow::class.java)
            startActivity(intent)
        }

        btnLogo3.setOnClickListener {
            val intent = Intent(this, InfomationActivity::class.java)
            startActivity(intent)
        }

        btnRow3.setOnClickListener {
            val intent = Intent(this, InfomationActivity::class.java)
            startActivity(intent)
        }

        btnLogo4.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

        btnRow4.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }
    }


}