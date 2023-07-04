package com.example.evcilhayvanapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.evcilhayvanapp.view.animalsdetails

class AnimalsAdapter(var mList : List<animalsdata>) : RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder>() {
     var onItemClick : ((animalsdata) -> Unit)?  =null

    class AnimalsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){ //inner yazıyordu basta sildim


        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)

    }
fun setFilteredList(mList: List<animalsdata>){
    this.mList=mList
    notifyDataSetChanged()

}




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return AnimalsViewHolder(view)

    }
    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        val anim  = mList[position]
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text=mList[position].title

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(anim)
        }

    }
    override fun getItemCount(): Int {
        return mList.size
    }





    }


