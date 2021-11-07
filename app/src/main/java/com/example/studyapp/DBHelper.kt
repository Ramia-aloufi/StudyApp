package com.example.studyapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,"Items5.db",null,1) {
   private var sdb:SQLiteDatabase = writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table Kotlin ( id Integer Primary key ,title text,description text)")
            p0.execSQL("create table Android ( id Integer Primary key ,title text,description text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun savedKotlindata(n1:Item): Long {
        val cv = ContentValues()
        cv.put("title",n1.title)
        cv.put("description",n1.description)
        var status = sdb.insert("Kotlin",null,cv)
        return status

    }
    fun savedAndroiddata2(n1:Item): Long {
        val cv = ContentValues()
        cv.put("title",n1.title)
        cv.put("description",n1.description)
        var status = sdb.insert("Android",null,cv)
        return status

    }
    @SuppressLint("Range")
    fun retriveKotlinData():ArrayList<Item>{
        var al = arrayListOf<Item>()
        var c : Cursor = sdb.query("Kotlin",null,null, null,null,null,null)
        if (c.moveToFirst()) {
            var id:Int? = null
            var title:String? = null
            var disc:String? = null
            do {
                id = c.getInt(c.getColumnIndex("id"))
                title =c.getString(c.getColumnIndex("title"))
                disc =c.getString(c.getColumnIndex("description"))
                al.add(Item(id,title,disc))
            } while (c.moveToNext());
        }
        return al
    }
    @SuppressLint("Range")
    fun retriveAnndroidData2():ArrayList<Item>{
        var al = arrayListOf<Item>()
        var c : Cursor = sdb.query("Android",null,null, null,null,null,null)
        if (c.moveToFirst()) {
            var id:Int? = null
            var title:String? = null
            var disc:String? = null
            do {
                id = c.getInt(c.getColumnIndex("id"))
                title =c.getString(c.getColumnIndex("title"))
                disc =c.getString(c.getColumnIndex("description"))
                al.add(Item(id,title,disc))
            } while (c.moveToNext());
        }
        return al
    }
    fun updateAndroid(s1:String,s2: String,s3:Int?): Int {
        var cv = ContentValues()
        cv.put("title",s1)
        cv.put("description",s2)
        var status = sdb.update("Android",cv,"id=?", arrayOf(s3.toString()))
        return status

    }
    fun updateKotlin(s1:String,s2: String,s3:Int?): Int {
        var cv = ContentValues()
        cv.put("title",s1)
        cv.put("description",s2)
        var status = sdb.update("Kotlin",cv,"id=?", arrayOf(s3.toString()))
        return status

    }
    fun deleteKotlin(s1:Int):Int{
        var nn =  sdb.delete("Kotlin","id=?", arrayOf(s1.toString()))
        return nn
    }
    fun deleteAndroid(s1:Int):Int{
        var nn =  sdb.delete("Android","id=?", arrayOf(s1.toString()))
        return nn
    }

}