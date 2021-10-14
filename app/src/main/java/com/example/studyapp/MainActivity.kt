package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Items(val a1:String,val a2:String)

class MainActivity : AppCompatActivity() {
    lateinit var Kotlin: Button
    lateinit var Android: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Kotlin = findViewById(R.id.Kotlin)
        Android = findViewById(R.id.Android)

        Android.setOnClickListener {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        Kotlin.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }


    }
}