package com.example.diet.FoodList

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.diet.R
import com.example.diet.TooDiet.TooDietDatabase
import com.example.diet.TooDiet.TooDietModel

class FoodListActivity: AppCompatActivity()  {
    private lateinit var btnSave: Button
    //private lateinit var editType: EditText
    private lateinit var editFoodName: EditText
    private lateinit var editAmount: EditText
    private lateinit var editCalories: EditText
    private lateinit var btnBack: RelativeLayout

    private lateinit var tooDietDatabase: TooDietDatabase

    private lateinit var option: Spinner
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food_list)
        getSupportActionBar()?.hide()


        selectionSort()
        initView()
        tooDietDatabase = TooDietDatabase(this)
        btnSave.setOnClickListener {
            addFood()
        }

        btnBack.setOnClickListener {
            var intent = Intent(this, FoodListShow::class.java)
            startActivity(intent)
        }


    }

    private fun selectionSort(){
        option = findViewById(R.id.sp_option) as Spinner
        result = findViewById(R.id.tv_result) as TextView

        val options = arrayOf("อาหาร", "ผัก", "ผลไม้", "ขนม")

        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = "กรุณาเลือกตัวเลือก"
            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = options.get(position)
            }
        }
    }

    private  fun addFood(){
        val Foodname = editFoodName.text.toString()
        //val Type = editType.text.toString()
        val Type = result.text.toString()
        val Amount = editAmount.text.toString()
        val Calories = editCalories.text.toString()

//        if(Foodname.isEmpty()||Type.isEmpty()||Amount.isEmpty()||Calories.isEmpty()){
        if(Foodname.isEmpty()||Amount.isEmpty()||Calories.isEmpty()){
            Toast.makeText(this, "กรุณากรอกข้อมูลทุกช่อง", Toast.LENGTH_SHORT).show()
        }else{
            val  tdm = TooDietModel(Name = Foodname, Calories = Calories, Amount = Amount, Type = Type )
            val status = tooDietDatabase.addData(tdm)

            var intent = Intent(this, FoodListShow::class.java)
            startActivity(intent)

            if (status >-1){
                Toast.makeText(this, "บันทึกเสร็จสิ้น", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "ไม่สามารถบันทึกได้", Toast.LENGTH_SHORT).show()
            }

            if (Type == "อาหาร"){

            }else if (Type == "ผัก"){

            }else if (Type == "อาหาร"){

            }else if (Type == "อาหาร"){

            }
        }
    }

    private fun initView(){
        btnSave = findViewById(R.id.btnFLSave)
        //editType = findViewById(R.id.editType)
        editFoodName = findViewById(R.id.editFoodName)
        editAmount = findViewById(R.id.editFLAmount)
        editCalories = findViewById(R.id.editFLCalories)
        btnBack = findViewById(R.id.backbutton)
    }


}