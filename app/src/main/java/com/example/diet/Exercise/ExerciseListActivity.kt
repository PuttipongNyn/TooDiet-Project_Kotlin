package com.example.diet.Exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.diet.FoodList.FoodListShow
import com.example.diet.R
import com.example.diet.TooDiet.TooDietDatabase
import com.example.diet.TooDiet.TooDietModel

class ExerciseListActivity : AppCompatActivity() {
    private lateinit var btnSave: Button
    private lateinit var editExerciseName: EditText
    private lateinit var editHour: EditText
    private lateinit var editCalories: EditText
    private lateinit var btnBack: RelativeLayout

    private lateinit var tooDietDatabase: TooDietDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exercise_list)
        getSupportActionBar()?.hide()

        initView()
        tooDietDatabase = TooDietDatabase(this)
        btnSave.setOnClickListener {
            addExercise()
        }

        btnBack.setOnClickListener {
            var intent = Intent(this, ExerciseListShow::class.java)
            startActivity(intent)
        }


    }


    private  fun addExercise(){
        val Exercisename = editExerciseName.text.toString()
        val Hour = editHour.text.toString()
        val Calories = editCalories.text.toString()

        if(Exercisename.isEmpty()||Hour.isEmpty()||Calories.isEmpty()){
            Toast.makeText(this, "กรุณากรอกข้อมูลทุกช่อง", Toast.LENGTH_SHORT).show()
        }else{
            val  tdm = TooDietModel(NameEx = Exercisename, CaloriesEx = Calories, Hour = Hour,  )
            val status = tooDietDatabase.addDataEx(tdm)

            var intent = Intent(this, ExerciseListShow::class.java)
            startActivity(intent)

            if (status >-1){
                Toast.makeText(this, "บันทึกเสร็จสิ้น", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "ไม่สามารถบันทึกได้", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun initView(){
        btnSave = findViewById(R.id.btnExSave)
        editExerciseName = findViewById(R.id.editExerciseName)
        editHour = findViewById(R.id.editHour)
        editCalories = findViewById(R.id.editExCalories)
        btnBack = findViewById(R.id.backbutton)
    }

}