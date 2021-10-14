package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    lateinit var al:ArrayList<Items>
    lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        al = arrayListOf(
            Items("RecyclerView","using with array list or list"),
            Items("SharedPrefrences","to save item locally"),
            Items("Toast","to show amassege in some cases"),
            Items("Alert Dialog","to show alert"),
            Items("Intent","To go to another mainactivity")
        )
        rv = findViewById(R.id.rv)
        rv.adapter?.notifyDataSetChanged()
        rv.adapter = RVAdapter(al,this)
        rv.layoutManager = LinearLayoutManager(this)
    }
}