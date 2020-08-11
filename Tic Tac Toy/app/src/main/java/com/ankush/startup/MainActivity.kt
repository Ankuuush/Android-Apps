package com.ankush.startup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun bslct(view:View)
    {
        var buslct=view as Button
        var cellid:Int=0
        when(buslct.id)
        {
            R.id.b1 -> cellid=1
            R.id.b2 -> cellid=2
            R.id.b3 -> cellid=3
            R.id.b4 -> cellid=4
            R.id.b5 -> cellid=5
            R.id.b6 -> cellid=6
            R.id.b7 -> cellid=7
            R.id.b8 -> cellid=8
            R.id.b9 -> cellid=9
            else ->
            {}
        }
        play(cellid,buslct)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var loser=ArrayList<Int>()
    var activeplayer=1
    fun play(cellid:Int,buslct:Button)
    {
        if(activeplayer==1)
        {
            buslct.text="X"
            buslct.setBackgroundColor(Color.GREEN)
            player1.add(cellid)
            loser.add(cellid)
            activeplayer=2

        }
        else
        {
            buslct.text="0"
            buslct.setBackgroundColor(Color.YELLOW)
            player2.add(cellid)
            loser.add(cellid)
            activeplayer=1

        }
        buslct.isEnabled=false
        winner()
    }
    fun winner()
    {
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            stop()
            Toast.makeText(this, "USER WON", Toast.LENGTH_LONG).show()
        }
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            stop()
            Toast.makeText(this, "COMPUTER WON", Toast.LENGTH_LONG).show()
        }
        else if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            stop()
            Toast.makeText(this, "USER WON", Toast.LENGTH_LONG).show()
        }
        else if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            stop()
            Toast.makeText(this, "COMPUTER WON", Toast.LENGTH_LONG).show()
        }
        else if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            stop()
            Toast.makeText(this, "USER WON", Toast.LENGTH_LONG).show()
        }
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            stop()
            Toast.makeText(this, "COMPUTER WON", Toast.LENGTH_LONG).show()
        }
        else if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            stop()
            Toast.makeText(this, "USER WON", Toast.LENGTH_LONG).show()
        }
        else if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            stop()
            Toast.makeText(this, "COMPUTER WON", Toast.LENGTH_LONG).show()
        }
        else if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            stop()
            Toast.makeText(this, "USER WON", Toast.LENGTH_LONG).show()
        }
        else if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            stop()
            Toast.makeText(this, "COMPUTER WON", Toast.LENGTH_LONG).show()
        }
        else if(player1.contains(3) && player1.contains(9) && player1.contains(6))
        {
            stop()
            Toast.makeText(this, "USER WON", Toast.LENGTH_LONG).show()
        }
        else if(player2.contains(3) && player2.contains(9) && player2.contains(6))
        {
            stop()
            Toast.makeText(this, "COMPUTER WON", Toast.LENGTH_LONG).show()
        }
        else if (loser.contains(1) && loser.contains(2) && loser.contains(3) && loser.contains(4) && loser.contains(5) && loser.contains(6) && loser.contains(7) && loser.contains(8) && loser.contains(9))
        {
            Toast.makeText(this, "NOBODY WON", Toast.LENGTH_LONG).show()
        }
        else if(activeplayer==2)
        {
            auto()
        }
    }
    fun stop()
    {
        for (i in 1..9)
        {
            if(!loser.contains(i))
            {
                when(i)
                {
                    1 -> b1.isEnabled=false
                    2 -> b2.isEnabled=false
                    3 -> b3.isEnabled=false
                    4 -> b4.isEnabled=false
                    5 -> b5.isEnabled=false
                    6 -> b6.isEnabled=false
                    7 -> b7.isEnabled=false
                    8 -> b8.isEnabled=false
                    9 -> b9.isEnabled=false
                }
            }
        }
    }
    fun auto()
    {
        var comp=ArrayList<Int>()
        for(i in 1..9)
        {
            if(!loser.contains(i))
            {
                comp.add(i)
            }
        }
        var r=Random()
        var rd=r.nextInt(comp.size)
        var cellid:Int=comp[rd]
        var buslct:Button
        when(cellid)
        {
            1 -> buslct=b1
            2 -> buslct=b2
            3 -> buslct=b3
            4 -> buslct=b4
            5 -> buslct=b5
            6 -> buslct=b6
            7 -> buslct=b7
            8 -> buslct=b8
            9 -> buslct=b9
            else ->
            {buslct=b1}
        }
        play(cellid, buslct)
    }
}
