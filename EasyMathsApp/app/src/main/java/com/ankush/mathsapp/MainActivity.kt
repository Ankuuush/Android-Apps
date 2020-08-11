package com.ankush.mathsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun but(view: View)
    {
        val str=name.text.toString()
        val intent=Intent(this,option::class.java)
        intent.putExtra("msg",str)
        startActivity(intent)
    }
}
