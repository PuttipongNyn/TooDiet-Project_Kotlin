package com.example.diet.FoodList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.diet.R
import com.example.diet.TooDiet.TooDietModel

class FoodListAdapter: RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>() {

    private var tooDiet: ArrayList<TooDietModel> = ArrayList()

    private var onClickDeleteItem: ((TooDietModel) -> Unit)? = null
    private var onClickCalItem: ((TooDietModel) -> Unit)? = null

    fun addItems(items: ArrayList<TooDietModel>){
        this.tooDiet = items
    }

    fun setonClickDeleteItem(callback:(TooDietModel) -> Unit){
        this.onClickDeleteItem = callback
    }
    fun setonClickCalItem(callback:(TooDietModel) -> Unit){
        this.onClickCalItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_food_list, parent, false)
    )

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        val fl = tooDiet[position]
        holder.bindView(fl)
        if (fl.Type == "อาหาร"){
            holder.Img.setImageResource(R.drawable.ic_food)
        }else if(fl.Type == "ผัก"){
            holder.Img.setImageResource(R.drawable.ic_vegetarian)
        }else if(fl.Type == "ผลไม้"){
            holder.Img.setImageResource(R.drawable.ic_vegetables)
        }else if(fl.Type == "ขนม"){
            holder.Img.setImageResource(R.drawable.ic_dessert)
        }



        holder.btnDelete.setOnClickListener { onClickDeleteItem?.invoke(fl) }

        holder.btnAdd.setOnClickListener { onClickCalItem?.invoke(fl) }

        val isVisible : Boolean = fl.visibility
        holder.exLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.itemsLayout.setOnClickListener {

            fl.visibility = !fl.visibility
            notifyItemChanged(position)
        }



    }

    override fun getItemCount(): Int {
       return tooDiet.size
    }


    class FoodListViewHolder(var view: View): RecyclerView.ViewHolder(view){
        //private var ID = view.findViewById<TextView>(R.id.tvID)
        private var Name = view.findViewById<TextView>(R.id.tvName)
        private var Calories = view.findViewById<TextView>(R.id.tvCalories)
        private var Amount = view.findViewById<TextView>(R.id.tvAmount)
        private var Type = view.findViewById<TextView>(R.id.tvType)
        var Img = view.findViewById<ImageView>(R.id.imgFoodType)
        var btnDelete = view.findViewById<Button>(R.id.btnDelete)
        var btnAdd = view.findViewById<Button>(R.id.btnAddSum)
        var exLayout = view.findViewById<ConstraintLayout>(R.id.expandedLayout)
        var itemsLayout = view.findViewById<RelativeLayout>(R.id.itemsLayout)


        fun bindView(flm: TooDietModel){
            Name.text = flm.Name
            Calories.text = flm.Calories
            Amount.text = flm.Amount
            Type.text == flm.Type

        }
    }
}