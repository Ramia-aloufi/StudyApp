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
            Items("For Loops"," need something to happen multiple times"),
            Items("While Loops","similar to For Loops."),
            Items("When","perform a check in a more concise way "),
            Items("Try/Catch","Error handling is a major part of programming."),
            Items("If Statements","one of the most fundamental aspects of programming.")
        )
        rv = findViewById(R.id.rv)
        rv.adapter?.notifyDataSetChanged()
        rv.adapter = RVAdapter(al,this)
        rv.layoutManager = LinearLayoutManager(this)
    }
}