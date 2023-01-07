package com.example.diet.Exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.diet.R
import com.example.diet.TooDiet.TooDietModel

class ExerciseListAdapter: RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExerciseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_exercise_list, parent, false)
    )

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val ex = tooDiet[position]
        holder.bindView(ex)

        holder.btnDeleteEx.setOnClickListener { onClickDeleteItem?.invoke(ex) }

        holder.btnAddEx.setOnClickListener { onClickCalItem?.invoke(ex) }

        val isVisible : Boolean = ex.visibility
        holder.exLayout2.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.itemsLayoutEx.setOnClickListener {

            ex.visibility = !ex.visibility
            notifyItemChanged(position)
        }



    }

    override fun getItemCount(): Int {
       return tooDiet.size
    }


    class ExerciseViewHolder(var view: View): RecyclerView.ViewHolder(view){

        private var NameEx = view.findViewById<TextView>(R.id.tvNameEx)
        private var CaloriesEx = view.findViewById<TextView>(R.id.tvCaloriesEx)
        private var Hour = view.findViewById<TextView>(R.id.tvHour)
        var btnDeleteEx = view.findViewById<Button>(R.id.btnDeleteEx)
        var btnAddEx = view.findViewById<Button>(R.id.btnAddSumEx)
        var exLayout2 = view.findViewById<ConstraintLayout>(R.id.expandedLayoutEx)
        var itemsLayoutEx = view.findViewById<RelativeLayout>(R.id.itemsLayoutEx)

        fun bindView(flm: TooDietModel){
            NameEx.text = flm.NameEx
            CaloriesEx.text = flm.CaloriesEx
            Hour.text = flm.Hour
        }
    }
}