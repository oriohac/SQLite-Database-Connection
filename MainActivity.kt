package com.example.loginplatform


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_layout.*
import kotlinx.android.synthetic.main.signup.*

class MainActivity : AppCompatActivity() {
lateinit var handler:  Database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Database(this)
        showHome()
        login_main.setOnClickListener {
            showLogin()
        }
        signup_main.setOnClickListener {
            showSignup()
        }
        signup.setOnClickListener {
            handler.insertData(signup_username.text.toString(),signup_email.text.toString(),signup_password.text.toString())
            Toast.makeText(this,"signUp success",Toast.LENGTH_LONG).show()
            showHome()

        }
        Login.setOnClickListener {
  if (handler.userPresent (login_email.text.toString(),login_password.text.toString()))
      Toast.makeText(this, "Login success nice person   ", Toast.LENGTH_LONG).show()

            else Toast.makeText(this,"check Username and Password", Toast.LENGTH_LONG).show()
            showHome()
        }

    }
    private fun showHome(){
        home.visibility = View.VISIBLE
            loginpage.visibility = View.GONE
        signuppage.visibility = View.GONE

}
    private  fun showSignup(){
        home.visibility = View.GONE
        loginpage.visibility = View.GONE
        signuppage.visibility = View.VISIBLE
    }

    private  fun showLogin(){
        home.visibility = View.GONE
        loginpage.visibility = View.VISIBLE
            signuppage.visibility = View.GONE
    }


}