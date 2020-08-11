package com.ankush.mathsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_mat_mul.*

class MatMul : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mat_mul)
    }
    var rowa:Int=0
    var cola:Int=0
    var rowb:Int=0
    var colb:Int=0
    var A=Array(0,{IntArray(0)})
    var B=Array(0,{IntArray(0)})
    fun sizearr(view: View)
    {
         rowa=ra.text.toString().toInt()
         cola=ca.text.toString().toInt()
         rowb=rb.text.toString().toInt()
         colb=cb.text.toString().toInt()
         A=Array(rowa,{IntArray(cola)})
         B=Array(rowb,{IntArray(colb)})
        sizearr.isEnabled=false
    }
    var row=0
    var col=0
    fun matA(view: View) {
        A[row][col] = valA.text.toString().toInt()
        if ((col == cola - 1) && (row == rowa - 1)) {
            valA.setText("")
            row=0
            col=0
            data.isEnabled = false
        }
        else if (col == cola - 1) {
            col = 0
            row++
            valA.setText("")
        } else {
            col++
            valA.setText("")
        }

    }
    fun matB(view: View)
    {
        B[row][col]=valB.text.toString().toInt()
        if ((col==colb-1)&&(row==rowb-1))
        {
            valB.setText("")
            dataB.isEnabled= false
        }
         else if(col==colb-1) {
            col = 0
            row++
            valB.setText("")
        }
        else {
            col++
            valB.setText("")
        }

    }
    var c=""
    var rslt=Array(0,{IntArray(0)})
    fun mulans(view: View)
    {
        rslt=Array(rowa,{IntArray(colb)})
        for (i in 0..rowa-1)
        {
            for (j in 0..colb-1)
            {
                for (k in 0..cola-1)
                {
                    rslt[i][j]+=A[i][k]*B[k][j]
                }
                 c=c+rslt[i][j].toString()
                ans.text=c
                c=c+" "
            }
             c=c+"\n"
        }
    }
}

