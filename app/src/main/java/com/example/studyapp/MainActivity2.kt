package com.example.studyapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity2 : AppCompatActivity() {
    lateinit var al:ArrayList<Item>
    lateinit var rv: RecyclerView
    lateinit var btnadd:FloatingActionButton
    lateinit var db:DBHelper
    lateinit var dialog: com.example.studyapp.Dialog
    var TAG = "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnadd = findViewById(R.id.floatingActionButton)
        db = DBHelper(this)
        dialog = Dialog()
//        al = arrayListOf(
//            Item(null,"For Loops"," need something to happen multiple times"),
//            Item(null,"While Loops","similar to For Loops."),
//            Item(null,"When","perform a check in a more concise way "),
//            Item(null,"Try/Catch","Error handling is a major part of programming."),
//            Item(null,"If Statements","one of the most fundamental aspects of programming.")
//        )
        rv = findViewById(R.id.rv)

        rvUp()
        btnadd.setOnClickListener {
            preSave()
        }
    }

    fun add(na:String,n4:String){
        var items = Item(null,na,n4)
        if(items.title.isNotEmpty() && items.description.isNotEmpty()) {
            var status = db.savedKotlindata(items)
            if (status < 1) {
                Toast.makeText(this, "Data not Saved ", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
                rvUp()
            }
        }else{
            Toast.makeText(this, "Data Could Not Be Empty", Toast.LENGTH_SHORT).show()

        }

    }

    fun preSave(){
        var txt1 = EditText(this)
        var txt2 = EditText(this)
        val layout = LinearLayout(this)
        layout.addView(txt1)
        layout.addView(txt2)
        layout.orientation = LinearLayout.VERTICAL
        txt1.hint = "titel"
        txt2.hint = "description"
        AlertDialog.Builder(this)
            .setPositiveButton("Add", DialogInterface.OnClickListener { _, _ ->
                add(txt1.text.toString(),txt2.text.toString())
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                dialog.cancel()
            })
            .setTitle("Add New Item")

            .setView(layout)
            .create()
            .show()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun UpdatOrDelete(a1:Item){
        Log.d(TAG,"$a1")
        dialog.createDealog(a1,this)

    }
    fun updateKotlin(a1:Item){
        var rr = db.updateKotlin(a1.title,a1.description,a1.id)
        Toast.makeText(this,"$rr Updated successfully..!",Toast.LENGTH_SHORT).show()
        rvUp()
        Log.d(TAG,"$a1")
    }

    fun deleteKotlin(a1:Item){
        var rr = db.deleteKotlin(a1.id!!)
        Toast.makeText(this,"$rr deleteed successfully..!",Toast.LENGTH_SHORT).show()
        rvUp()
    }

    fun rvUp(){
        rv.adapter?.notifyDataSetChanged()
        rv.adapter = RVAdapter((db.retriveKotlinData()) as ArrayList<Item>,this)
        rv.layoutManager = LinearLayoutManager(this)
    }
}