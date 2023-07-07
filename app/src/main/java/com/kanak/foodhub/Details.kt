package com.kanak.foodhub

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlin.coroutines.coroutineContext

class Details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var txtName = findViewById<TextView>(R.id.txtName)
        val Name = getIntent().getStringExtra("Name")
        txtName.setText(Name)

        var txtEmail = findViewById<TextView>(R.id.txtEmail)
        val Email = getIntent().getStringExtra("Email")
        txtEmail.setText(Email)

        var txtNumber = findViewById<TextView>(R.id.txtNUmber)
        val Number = getIntent().getStringExtra("Number")
        txtNumber.setText(Number)

        var txtAddress = findViewById<TextView>(R.id.txtAddress)
        val Address = getIntent().getStringExtra("Address")
        txtAddress.setText(Address)
    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_login)
    }
}