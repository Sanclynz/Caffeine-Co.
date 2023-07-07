package com.kanak.foodhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ForgotPage : AppCompatActivity() , View.OnClickListener {
    lateinit var etEmail : EditText
    lateinit var etMobileNumber:EditText
    lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_page)

        etEmail=findViewById(R.id.etEmail)
        etMobileNumber=findViewById(R.id.etMobileNumber)
        btnNext=findViewById(R.id.btnNext)

        btnNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val Email=etEmail.text.toString()
        val intent = Intent(this,Details2::class.java)
        intent.putExtra("Email",Email)

        val Number=etMobileNumber.text.toString()
        intent.putExtra("Number",Number)
        startActivity(intent)

    }

}