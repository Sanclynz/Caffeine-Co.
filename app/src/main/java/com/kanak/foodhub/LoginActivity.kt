package com.kanak.foodhub

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(),View.OnClickListener {

     lateinit var etMobileNumber : EditText
     lateinit var etPassword : EditText
     lateinit var btnLogin : Button
     lateinit var txtForgotPassword : TextView
     lateinit var txtNoAccount : TextView

     lateinit var sharedPreference : SharedPreferences

     val validMobileNumber= "0123456789"
     val validPassword="kanak"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        sharedPreference= getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        val preference=sharedPreference.getBoolean("loggedIn",false)

        if(preference){
            val intent = Intent(this,WelcomePage::class.java)
            startActivity(intent)

        }
        else{
            setContentView(R.layout.activity_login)

        }



        title="Login"

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtNoAccount=findViewById(R.id.txtNoAccount)


        btnLogin.setOnClickListener(this)
        txtNoAccount.setOnClickListener(this)
        txtForgotPassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val view = v?.rootView
        when(v?.id){
            R.id.btnLogin ->{
                val mobileNumber = etMobileNumber.text.toString()
                val password = etPassword.text.toString()
                if(  (mobileNumber ==validMobileNumber) && (password==validPassword)){
                    preference()
                }
                else{
                    Toast.makeText(this@LoginActivity,"incorrect Credentials",Toast.LENGTH_LONG).show()
                }
            }
            R.id.txtNoAccount ->{
                val intent = Intent(this,RegisterPage::class.java)
                startActivity(intent)

            }
            R.id.txtForgotPassword ->{
                val intent = Intent(this,ForgotPage::class.java)
                startActivity(intent)

            }

        }


    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun preference(){
        sharedPreference.edit().putBoolean("loggedIn",true).apply()
    }


}