package com.example.studyapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cards.view.*


class RVAdapter(var item:ArrayList<Item>, var context: Context):RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cards,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var items = item[position]
        holder.itemView.apply {
            tv1.text = items.title
            tv2.text = items.description
            MyCard.setOnClickListener {
                if (context is MainActivity2){
                    (context as MainActivity2).UpdatOrDelete(items)
                }else{
                    (context as MainActivity3).UpdatOrDelete(items)
                }
            }
        }
    }
    override fun getItemCount() = item.size
}