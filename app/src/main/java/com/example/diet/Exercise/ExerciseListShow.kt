package com.example.diet.Exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diet.MainActivity
import com.example.diet.R
import com.example.diet.TooDiet.TooDietDatabase

class ExerciseListShow : AppCompatActivity() {
    private lateinit var btnBack: RelativeLayout
    private lateinit var btnAdd: RelativeLayout
    private lateinit var SummaryEx: RelativeLayout
    private lateinit var tooDietDatabase: TooDietDatabase
    private lateinit var recyclerView: RecyclerView
    private var listAdapter: ExerciseListAdapter? = null
    private lateinit var txtSum: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)
        getSupportActionBar()?.hide()

        initView()
        initRecyclerView()
        tooDietDatabase = TooDietDatabase(this)
        getAllExercise()
        showkCal()

        SummaryEx.setOnClickListener {
            clearTemp()
        }

        btnBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnAdd.setOnClickListener {
            var intent = Intent(this, ExerciseListActivity::class.java)
            startActivity(intent)
        }

        listAdapter?.setonClickDeleteItem {
            deleteExercise(it.IdEx)
        }

        listAdapter?.setonClickCalItem {
            calEx(it.IdEx,it.CaloriesEx)
        }

    }

    private fun calEx(id:Int,calories:String){
        tooDietDatabase.addCalExById(id,calories)
        //getAllFood()
        recreate()
    }

    private fun clearTemp(){
        var db = TooDietDatabase(applicationContext)
        val builder = AlertDialog.Builder(this)
        builder.setMessage("ต้องการจะล้างที่เลือกหรือไม่ ?")
        builder.setCancelable(true)
        builder.setPositiveButton("ใช่"){ dialog, _->
            getAllExercise()
            db.clearTempEx()
            dialog.dismiss()
            recreate()
//            var intent = Intent(this, FoodListShow::class.java)
//            startActivity(intent)
        }
        builder.setNegativeButton("ไม่"){ dialog, _->
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()
    }

    private fun showkCal(){
        var db = TooDietDatabase(applicationContext)

        val cursor = db.getTemp()

        cursor!!.moveToFirst()
        txtSum.append(cursor.getString(cursor.getColumnIndexOrThrow(TooDietDatabase.SumEx)) + "kCal")
    }

    private fun getAllExercise(){
        val exerciseList = tooDietDatabase.getAllExercise()
        Log.e("PPPP", "${exerciseList.size}")

        listAdapter?.addItems(exerciseList)
    }

    private fun deleteExercise(id:Int){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("ต้องการจะลบข้อมูลหรือไม่ ?")
        builder.setCancelable(true)
        builder.setPositiveButton("ใช่"){ dialog, _->
            tooDietDatabase.deleteExerciseById(id)
            getAllExercise()
            dialog.dismiss()
            finish()
            var intent = Intent(this, ExerciseListShow::class.java)
            startActivity(intent)
//            recreate()
        }
        builder.setNegativeButton("ไม่"){ dialog, _->
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        listAdapter = ExerciseListAdapter()
        recyclerView.adapter = listAdapter
    }

    private fun initView(){
        recyclerView = findViewById(R.id.listViewEx)
        btnBack = findViewById(R.id.backbutton)
        btnAdd = findViewById(R.id.AddButton)
        txtSum = findViewById(R.id.txtSumEx)
        SummaryEx = findViewById(R.id.SummaryEx)
    }

}