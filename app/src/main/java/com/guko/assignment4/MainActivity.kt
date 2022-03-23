package com.guko.assignment4

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SimpleDateFormat")
    fun selectDate(view : View){
        val c = Calendar.getInstance()

        DatePickerDialog(this, { datePicker, yy, mm, dd ->
            val date = "$dd/${mm+1}/$yy"
            tvDate.text = date
            val today = Date()
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val time:Date? = sdf.parse(date)


            val year = (today.time - time!!.time)/ 31536000000
            val month = (today.time - time.time)/ 2592000000
            val day = (today.time - time.time)/ 86400000

            tvTimes.text = "Day = $day\nMonth = $month\nYear = $year"
            tvAge.text = "Age:$year"



        },
        c.get(android.icu.util.Calendar.YEAR),android.icu.util.Calendar.MONTH,android.icu.util.Calendar.DAY_OF_MONTH).show()




    }
}