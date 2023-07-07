package com.kanak.foodhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterPage : AppCompatActivity(), View.OnClickListener{

    lateinit var etName: EditText
    lateinit var etEmail : EditText
    lateinit var etMobileNumber: EditText
    lateinit var etDeliveryAddress: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        title="Register Page"

        etName=findViewById(R.id.etName)
        etEmail=findViewById(R.id.etEmail)
        etMobileNumber=findViewById(R.id.etMobileNumber)
        etDeliveryAddress=findViewById(R.id.etDeliveryAddress)
        etPassword=findViewById(R.id.etPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtRegister=findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener(this)

    }


    override fun onClick(p0: View?) {
        val password=etPassword.text.toString()
        val confirmPassword=etConfirmPassword.text.toString()
        if(password==confirmPassword){
            val Name = etName.text.toString()
            val intent = Intent(this,Details::class.java)
            intent.putExtra("Name",Name)


            val Email = etEmail.text.toString()
            intent.putExtra("Email",Email)


            val MobileNumber = etMobileNumber.text.toString()
            intent.putExtra("Number",MobileNumber)


            val Address = etDeliveryAddress.text.toString()
            intent.putExtra("Address",Address)
            startActivity(intent)


        }
        else{
            Toast.makeText( this,"Passwords Don't Match to each other", Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_login)
    }

}