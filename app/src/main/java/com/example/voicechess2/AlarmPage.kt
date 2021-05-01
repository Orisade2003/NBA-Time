package com.example.voicechess2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.chaquo.python.Python
import android.view.View
import android.widget.*
import com.chaquo.python.PyObject
import com.chaquo.python.android.AndroidPlatform
import org.w3c.dom.Text



class AlarmPage : AppCompatActivity() {
    public var game_day: String = ""
    public var game_month: String = ""
    public var game_year: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_page)

        if (!Python.isStarted())
            Python.start(AndroidPlatform(this))
        val py: Python = Python.getInstance()
        val pyobj: PyObject = py.getModule("nba_scores")

        date_choose()
        val search_btn: Button = findViewById<Button>(R.id.search)
        println("got here")
        search_btn.setOnClickListener(View.OnClickListener {
            fun OnClick(view : View)
            {
                println("got here2")
                val obj : PyObject = pyobj.callAttr("SportsDemo",game_day,game_month,game_year)
                val diff_games: TextView = findViewById<TextView>(R.id.all_games)
                println("these are the games")
                println(diff_games.toString())
                diff_games.text = diff_games.toString()
            }


        })

    }
    fun date_choose() {
        val days: MutableList<Int> = mutableListOf<Int>()
        val months: MutableList<Int> = mutableListOf<Int>()
        val years: MutableList<Int> = mutableListOf<Int>()


        for (i in 1..31) {
            days.add(i)

        }
        println("here we are")
        println(days)
        for (i in 1..12) {
            months.add(i)
        }
        for (i in 2020..2021) {
            years.add(i)
        }



        val daysdd = findViewById<Spinner>(R.id.day)
        if (daysdd != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, days
            )
            daysdd.adapter = adapter
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)



    }
        val monthdd = findViewById<Spinner>(R.id.month)
        if (monthdd != null) {
            val adapter2 = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, months
            )
            monthdd.adapter = adapter2
            adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        }

        val yeardd = findViewById<Spinner>(R.id.year)
        if (yeardd != null) {
            val adapter3 = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, years
            )
            yeardd.adapter = adapter3
            adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)



        }
        game_day = daysdd.getSelectedItem().toString()
        game_month =  monthdd.getSelectedItem().toString()
        game_year = yeardd.getSelectedItem().toString()



}
    fun check_games()
    {


    }
    fun OnClick2(view : View)
    {
        if (!Python.isStarted())
            Python.start(AndroidPlatform(this))
        val py: Python = Python.getInstance()
        val pyobj: PyObject = py.getModule("nba_scores")
        println("got here2")
        val obj : PyObject = pyobj.callAttr("SportsDemo",game_day,game_month,game_year)
        val diff_games: TextView = findViewById<TextView>(R.id.all_games)
        println("these are the games")
        println(diff_games.toString())
        diff_games.text = diff_games.toString()
    }

}