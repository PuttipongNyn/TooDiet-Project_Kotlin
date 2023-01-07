package com.example.diet

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.diet.TooDiet.TooDietDatabase

class CaloriesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)
        getSupportActionBar()?.hide()
        var helper = TooDietDatabase(applicationContext)
        var db = helper.readableDatabase
        var targetWeight = "0"

        var seekBarKg = findViewById<SeekBar>(R.id.sbForTargetKg)
        var txtTargetWeight = findViewById<TextView>(R.id.textTargetKg)
        var editDate= findViewById<EditText>(R.id.editDate)
        var btnSaveResult = findViewById<Button>(R.id.saveResultNo2)

        seekBarKg.max = 50
        seekBarKg.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                txtTargetWeight.text = "" + progress.toString()
                targetWeight = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //value.text = "" + seekBar.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //value.text = "" + seekBar.toString()
            }
        })

        btnSaveResult.setOnClickListener {
            var date = editDate.text.toString()
            if (date == "0") {
                Toast.makeText(applicationContext, "กรุณาเลือกจำนวนวันที่ต้องการลดน้ำหนัก", Toast.LENGTH_SHORT).show()
            } else if (targetWeight == "0") {
                Toast.makeText(applicationContext, "กรุณาเลือกเป้าหมายน้ำหนักที่ต้องการลดน้ำหนัก", Toast.LENGTH_SHORT).show()
            } else {
                var cv = ContentValues()
                var builder = AlertDialog.Builder(this)
                var TDEE = intent.getStringExtra("TDEE")
                cv.put("WeightTarget",targetWeight)
                cv.put("Date",date)
                db.update("User",cv,"ID=" +1,null)
                val total = (TDEE!!.toFloat() * targetWeight.toFloat()) / (date.toFloat())
                builder.setMessage("พลังงานที่คุณใช้ในแต่ละวัน $TDEE kcal\nคุณต้องเผาผลาญพลังงาน $total แคลอรีต่อวัน\nเพื่อลดน้ำหนัก $targetWeight kg ใน $date วัน")
                builder.setCancelable(true)
                builder.setPositiveButton("ยืนยัน"){ dialog, _->
                    dialog.dismiss()
                    finish()
                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)
                    Toast.makeText(applicationContext, "บันทึกข้อมูลเสร็จสิ้น!", Toast.LENGTH_SHORT).show()
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