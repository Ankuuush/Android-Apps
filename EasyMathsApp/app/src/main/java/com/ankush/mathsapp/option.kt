package com.ankush.mathsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_option.*

class option : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)
        val bundle:Bundle?=intent.extras
        val msg=bundle!!.getString("msg")
        head.text="Hi $msg ! Please select your choice."
        val opt= arrayOf("Calculator","Matrix Multiplication","Inverse of a Matrix","Feedback")
        listv.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,opt)
        listv.setOnItemClickListener { parent, view, position, id ->
            when(position)
            {
                0 -> {
                    var intent=Intent(this,Calculator::class.java)
                    startActivity(intent)
                }
                1 -> {
                    var intent=Intent(this,MatMul::class.java)
                    startActivity(intent)
                }
                2 -> {
                    var intent=Intent(this,InverseMatrix::class.java)
                    startActivity(intent)
                }
                3 -> {
                    var intent=Intent(this,Feedback::class.java)
                    startActivity(intent)
                }
            }
        }
        Toast.makeText(this,"Welcome to our app $msg",Toast.LENGTH_LONG).show()
    }
}
