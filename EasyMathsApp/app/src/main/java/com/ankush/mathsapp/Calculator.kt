package com.ankush.mathsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }
    var point=true
    var store:Float=0.0F
    var Data:String=""
    var data =ArrayList<Float>()
    var OP=ArrayList<String>()
    var cellId:String=""
    var check= true
    fun buslct(view: View)
    {
        if (check) {
            show.text = ""
        }
        check= false
        cellId=show.text.toString()
        var buslct= view as Button
        when(buslct.id)
        {
            R.id.b0 -> {
                cellId += "0"
                Data += "0"
            }
            R.id.b1 -> { cellId+="1"
                Data += "1"}
            R.id.b2 -> { cellId+="2"
                Data += "2" }
            R.id.b3 -> {
                cellId += "3"
                Data += "3"
            }
            R.id.b4 -> {
                cellId += "4"
                Data += "4"
            }
            R.id.b5 -> {
                cellId += "5"
                Data += "5"
            }
            R.id.b6 -> {
                cellId += "6"
                Data += "6"
            }
            R.id.b7 -> {
                cellId += "7"
                Data += "7"
            }
            R.id.b8 -> {
                cellId += "8"
                Data += "8"
            }
            R.id.b9 -> {
                cellId += "9"
                Data += "9"
            }
            R.id.b10 -> {
                if(point) {
                    cellId += "."
                    Data += "."
                    point = false
                }
            }
            R.id.b16 -> {
                cellId = "-" + cellId
                Data = "-" + Data
            }
            R.id.b17 -> {
                cellId += "00"
                Data += "00"
            }
        }

        show.text=cellId
    }
    fun op(view: View)
    {
        point=true
        data.add(Data.toFloat())
        Data=""
        var buslct= view as Button
        when(buslct.id) {
            R.id.b12 -> {
                cellId += "+"
                OP.add("+")
            }
            R.id.b13 -> {
                cellId += "-"
                OP.add("-")
            }
            R.id.b14 -> {
                cellId += "*"
                OP.add("*")
            }
            R.id.b15 ->{
                cellId += "/"
                OP.add("/")
            }
        }
        show.text=cellId
    }
    fun burslt(view: View)
    {
        data.add(Data.toFloat())
        Data=""
        var i:Int=-1
        do
        {
            i++
            if (OP[i]=="/")
            {
                store=data[i]/data[i+1]
                data[i]=store
                data.removeAt(i+1)
                OP.removeAt(i)
                i--
            }
        }while ((i!=OP.size-1)&&(OP.size!=0))
        i=-1
        while ((i!=OP.size-1)&&(OP.size!=0))
        {
            i++
            if (OP[i]=="*")
            {
                store=data[i]*data[i+1]
                data[i]=store
                data.removeAt(i+1)
                OP.removeAt(i)
                i--
            }
        }
        i=-1
        while ((i!=OP.size-1)&&(OP.size!=0))
        {
            i++
            if (OP[i]=="-")
            {
                store=data[i]-data[i+1]
                data[i]=store
                data.removeAt(i+1)
                OP.removeAt(i)
                i--
            }
        }
        i=-1
        while ((i!=OP.size-1)&&(OP.size!=0))
        {
            i++
            if (OP[i]=="+")
            {
                store=data[i]+data[i+1]
                data[i]=store
                data.removeAt(i+1)
                OP.removeAt(i)
                i--
            }
        }
        show.text=data[0].toString()
    }
    fun buac(view: View) {
        show.text="0"
        cellId=""
        data.clear()
        OP.clear()
        check=true
    }
}
