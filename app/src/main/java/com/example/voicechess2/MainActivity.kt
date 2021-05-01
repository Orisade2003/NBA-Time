package com.example.voicechess2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!Python.isStarted()) {
            val ap = AndroidPlatform(this)
            Python.start(ap)
        }
        val button =findViewById<Button>(R.id.test_button)
        button.setOnClickListener{
            val intent = Intent(this, AlarmPage::class.java)
            startActivity(intent)

        }
    }



    }




