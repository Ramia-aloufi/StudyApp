package com.example.studyapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity3 : AppCompatActivity() {
    lateinit var al:ArrayList<Item>
    lateinit var rv: RecyclerView
    lateinit var btnadd:FloatingActionButton
    lateinit var db:DBHelper
    lateinit var dialog: com.example.studyapp.Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btnadd = findViewById(R.id.floatingActionButton11)
        db = DBHelper(this)

        dialog = Dialog()
//        al = arrayListOf(
//            Item(null,"RecyclerView","using with array list or list"),
//            Item(null,"SharedPrefrences","to save item locally"),
//            Item(null,"Toast","to show amassege in some cases"),
//            Item(null,"Alert Dialog","to show alert"),
//            Item(null,"Intent","To go to another mainactivity")
//        )
        rv = findViewById(R.id.rv)

        rvUp()

        btnadd.setOnClickListener {
            preSave()
        }

    }

    fun add(na:String,n4:String){
        var items = Item(null,na,n4)
        var status = db.savedAndroiddata2(items)
        if (status < 1) {
            Toast.makeText(this, "Data not Saved ", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()

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

    fun UpdatOrDelete(a1:Item){
        dialog.createDealog(a1,this)

    }
    fun updateAndroid(a1:Item){
        var rr = db.updateAndroid(a1.title,a1.description,a1.id)
        Toast.makeText(this,"$rr Updated successfully..!",Toast.LENGTH_SHORT).show()
        rvUp()
    }

    fun deleteAndroid(a1:Item){
        var rr = db.deleteAndroid(a1.id!!)
        Toast.makeText(this,"$rr deleteed successfully..!",Toast.LENGTH_SHORT).show()
        rvUp()
    }

    fun rvUp(){
        rv.adapter?.notifyDataSetChanged()
        rv.adapter = RVAdapter((db.retriveAnndroidData2()) as ArrayList<Item>,this)
        rv.layoutManager = LinearLayoutManager(this)
    }
}