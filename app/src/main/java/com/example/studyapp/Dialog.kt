package com.example.studyapp

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class Dialog {
    fun createDealog(a1:Item,context:Context){
        var tv1 = EditText(context)
        var tv2 = EditText(context)
        var btn = Button(context)
        var btn1 = Button(context)
        var layout = LinearLayout(context)
        var tt = a1
        var dialog = Dialog(context)
        layout.setPadding(32,32,32,32)
        layout.orientation = LinearLayout.VERTICAL
        tv1.setText(a1.title)
        tv2.setText(a1.description)
        btn.setText("Update")
        btn1.setText("Delete")

        btn.setOnClickListener {
            if (context is MainActivity2){
                     tt = Item(a1.id,tv1.text.toString(),tv2.text.toString())
                (context as MainActivity2).updateKotlin(tt)
            }else{
                (context as MainActivity3).updateAndroid(tt)
            }
            dialog.cancel()


        }

        btn1.setOnClickListener {
            if (context is MainActivity2){
                (context as MainActivity2).deleteKotlin(a1)
            }else{
                (context as MainActivity3).deleteAndroid(a1)
            }
            dialog.cancel()
        }
        layout.addView(tv1)
        layout.addView(tv2)
        layout.addView(btn)
        layout.addView(btn1)
        dialog.window?.setLayout(200,400)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layout)
        dialog.create()
        dialog.show()
    }
}