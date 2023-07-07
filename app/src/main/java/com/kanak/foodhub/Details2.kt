package com.kanak.foodhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Details2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details2)

        val txtEmail=findViewById<TextView>(R.id.txtEmail)
        val Email=getIntent().getStringExtra("Email")
        txtEmail.setText(Email)

        val txtNumber=findViewById<TextView>(R.id.txtNUmber)
        val Number=getIntent().getStringExtra("Number")
        txtNumber.setText(Number)
    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_login)
    }
}