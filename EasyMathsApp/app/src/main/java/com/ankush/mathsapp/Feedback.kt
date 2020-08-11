package com.ankush.mathsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_feedback.*

class Feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
    }
    fun share(view: View)
    {
        val msg:String=fdbk.text.toString()
        val intent=Intent()
        intent.action=Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT,msg)
        intent.type="text/plain"
        startActivity(Intent.createChooser(intent,"Share to:"))
    }
}
