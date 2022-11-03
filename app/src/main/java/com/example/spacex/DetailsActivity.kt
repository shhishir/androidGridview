package com.example.spacex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val titleName = intent.getStringExtra("title")

        if (titleName!= null){
            val title : TextView = findViewById(R.id.titleOfItem)
            val dateF : TextView = findViewById(R.id.dateOfFlight)
            val flNum : TextView = findViewById(R.id.flightNum)
            val ytLink : TextView = findViewById(R.id.ytLink)
            val desc : TextView = findViewById(R.id.descriptions)

            title.text = titleName
            dateF.text = "Date of Flight : " + intent.getStringExtra("dateOF")
            flNum.text = "Rocket Id : " + intent.getStringExtra("flightNum")
            ytLink.text = "Article Link : "  +intent.getStringExtra("link")
            desc.text = "Details : " +intent.getStringExtra("desc")


        }
    }
}