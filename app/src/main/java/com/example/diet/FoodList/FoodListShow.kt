package com.example.diet.FoodList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diet.MainActivity
import com.example.diet.R
import com.example.diet.TooDiet.TooDietDatabase


class FoodListShow : AppCompatActivity() {
    private lateinit var btnBack: RelativeLayout
    private lateinit var btnAdd: RelativeLayout
    private lateinit var Summary: RelativeLayout
    private lateinit var txtSum: TextView

    private lateinit var tooDietDatabase: TooDietDatabase
    private lateinit var recyclerView: RecyclerView
    private var adapter: FoodListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_list)
        getSupportActionBar()?.hide()

        initView()
        initRecyclerView()
        tooDietDatabase = TooDietDatabase(this)
        getAllFood()
        showkCal()


        Summary.setOnClickListener {
            clearTemp()
        }

        btnBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnAdd.setOnClickListener {
            var intent = Intent(this, FoodListActivity::class.java)
            startActivity(intent)
        }

        adapter?.setonClickDeleteItem {
            deleteFood(it.Id)
        }

        adapter?.setonClickCalItem {
            calFood(it.Id,it.Calories)
        }
    }

    private fun getAllFood(){
        val foodList = tooDietDatabase.getAllFood()
        Log.e("PPPP", "${foodList.size}")

        adapter?.addItems(foodList)
    }

    private fun deleteFood(id:Int){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("ต้องการจะลบข้อมูลหรือไม่ ?")
        builder.setCancelable(true)
        builder.setPositiveButton("ใช่"){ dialog, _->
            tooDietDatabase.deleteFoodById(id)
            getAllFood()
            dialog.dismiss()
            finish()
            var intent = Intent(this, FoodListShow::class.java)
            startActivity(intent)
//            recreate()
        }
        builder.setNegativeButton("ไม่"){ dialog, _->
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()
    }

    private fun clearTemp(){
        var db = TooDietDatabase(applicationContext)
        val builder = AlertDialog.Builder(this)
        builder.setMessage("ต้องการจะล้างที่เลือกหรือไม่ ?")
        builder.setCancelable(true)
        builder.setPositiveButton("ใช่"){ dialog, _->
            getAllFood()
            db.clearTempFood()
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

    private fun calFood(id:Int,calories:String){
        tooDietDatabase.addCalFoodById(id,calories)
        //getAllFood()
        recreate()
    }

    private fun showkCal(){
        var db = TooDietDatabase(applicationContext)

        val cursor = db.getTemp()

        cursor!!.moveToFirst()
        txtSum.append(cursor.getString(cursor.getColumnIndexOrThrow(TooDietDatabase.SumFood)) + "kCal")
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = FoodListAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(){
        recyclerView = findViewById(R.id.listView)
        btnBack = findViewById(R.id.backbutton)
        btnAdd = findViewById(R.id.AddButton)
        txtSum = findViewById(R.id.txtSumFood)
        Summary = findViewById(R.id.Summary)
    }


}