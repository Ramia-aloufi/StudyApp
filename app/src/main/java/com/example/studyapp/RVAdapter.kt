package com.example.studyapp

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cards.view.*


class RVAdapter( var item:ArrayList<Items>,val mainactiv:Activity):RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
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
            tv1.text = items.a1
            tv2.text = items.a2
            MyCard.setOnClickListener {
//                Toast.makeText(mainactiv,items.a1,Toast.LENGTH_SHORT).show()
                var alert = AlertDialog.Builder(mainactiv)
                alert.setMessage(items.a2)
                alert.setTitle(items.a1)
                alert.setPositiveButton("Ok",DialogInterface.OnClickListener({
                    dialig, i ->  dialig.cancel()
                }))
                alert.create()
                alert.show()




            }

        }
    }

    override fun getItemCount() = item.size
}