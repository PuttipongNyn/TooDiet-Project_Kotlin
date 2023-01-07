package com.example.diet

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.diet.FoodList.FoodListShow
import com.example.diet.TooDiet.TooDietDatabase

class InfomationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        getSupportActionBar()?.hide()
        var helper = TooDietDatabase(applicationContext)
        var db = helper.readableDatabase

        var gender = "Null"
        var mintprogress = "0"
        var Acprogress = "0"
        var tdee = 0.0
        var activity = 0.0

        var slider = findViewById<SeekBar>(R.id.sbForKg)
        var Acslider = findViewById<SeekBar>(R.id.sbForActivity)
        var value = findViewById<TextView>(R.id.textHeight)
        var valueAc = findViewById<TextView>(R.id.textActivity)
        var btnMale = findViewById<RelativeLayout>(R.id.male)
        var btnFemale = findViewById<RelativeLayout>(R.id.female)
        var editAge = findViewById<EditText>(R.id.editAge)
        var editWeight = findViewById<EditText>(R.id.editWeight)
        var btnSave = findViewById<Button>(R.id.saveResult)
//        var weightLayout = findViewById<RelativeLayout>(R.id.weight)
//        var ageLayout = findViewById<RelativeLayout>(R.id.Age)
//
//        weightLayout.setOnClickListener{
//            editWeight.getText().clear()
//        }
//
//        ageLayout.setOnClickListener{
//            editAge.getText().clear()
//        }

        btnMale.setOnClickListener {
            btnMale.setBackgroundResource(R.drawable.btnfocus)
            btnFemale.setBackgroundResource(R.drawable.btnnotfocus)
            gender = "Male"
        }

        btnFemale.setOnClickListener {
            btnMale.setBackgroundResource(R.drawable.btnnotfocus)
            btnFemale.setBackgroundResource(R.drawable.btnfocus)
            gender = "Female"
        }

        slider.max = 300
        slider.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                value.text = "" + progress.toString()
                mintprogress = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //value.text = "" + seekBar.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //value.text = "" + seekBar.toString()
            }
        })
        Acslider.max = 5
        Acslider.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                valueAc.text = "" + progress.toString()
                Acprogress = progress.toString()
                if (Acprogress == "1"){
                    activity = 1.2
                }else if (Acprogress == "2"){
                    activity = 1.375
                }else if (Acprogress == "3"){
                    activity = 1.55
                }else if (Acprogress == "4"){
                    activity = 1.725
                }else if (Acprogress == "5"){
                    activity = 1.9
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //value.text = "" + seekBar.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //value.text = "" + seekBar.toString()
            }
        })

        btnSave.setOnClickListener {
            var weight = editWeight.text.toString()
            var age = editAge.text.toString()
            var bmr = 0.0
            if (gender == "Male") {
                bmr = 66 + (13.7 * weight.toFloat()) + (5 * mintprogress.toFloat()) - (6.8 * age.toFloat())
            }else if (gender == "Female") {
                bmr = 665 + (9.6 * weight.toFloat()) + (1.8 * mintprogress.toFloat()) - (4.7 * age.toFloat())
            }

            if (gender == "Null") {
                Toast.makeText(applicationContext, "Select Your Gender First", Toast.LENGTH_SHORT).show()
            } else if (mintprogress == "0") {
                Toast.makeText(applicationContext, "Select Your Height First", Toast.LENGTH_SHORT).show()
            } else if (Acprogress == "0") {
                Toast.makeText(applicationContext, "Select Your Range Activity", Toast.LENGTH_SHORT).show()
            } else if (age == "0" || age < "0") {
                 Toast.makeText(applicationContext, "Age is Incorrect", Toast.LENGTH_SHORT).show()
            } else if (weight == "0" || weight < "0") {
                Toast.makeText(applicationContext, "Weight Is Incorrect", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, CaloriesActivity::class.java)
                var builder = AlertDialog.Builder(this)

                tdee = bmr * activity
                val stringTdee = tdee.toString()
                intent.putExtra("TDEE", stringTdee)

                var cv = ContentValues()
                cv.put("Sex",gender)
                cv.put("Age",age)
                cv.put("Height",mintprogress)
                cv.put("Weight",weight)
                cv.put("BMR",bmr)
                cv.put("TDEE",tdee)
                db.update("User",cv,"ID=" +1,null)

                builder.setMessage("พลังงานที่จำเป็นพื้นฐานในการมีชีวิต $bmr kcal\nพลังงานที่คุณใช้ในแต่ละวัน $tdee kcal")
                builder.setCancelable(true)
                builder.setPositiveButton("ยืนยัน"){ dialog, _->
                    dialog.dismiss()
                    finish()
                    startActivity(intent)
                }
                builder.setNegativeButton("ยกเลิก"){ dialog, _->
                    dialog.dismiss()
                }
                val alert = builder.create()
                alert.show()

            }
        }
    }



}
