package com.example.myformapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SummaryActivity : AppCompatActivity() {
//    lateinit var myUser : User  // 'myUser' is the variable name and 'User' is the class name we have created
    lateinit var userFullName : TextView
    lateinit var userEmail : TextView
    lateinit var userPhone : TextView

    lateinit var title : String
    lateinit var firstName : String
    lateinit var lastName : String
    lateinit var phone : String
    lateinit var email : String
    lateinit var password : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        findViews()
        setValues()
        displayUser()
        clickListener()
    }
    private fun findViews() {
        userFullName = findViewById(R.id.text_view_user_full_name)
        userEmail = findViewById(R.id.text_view_user_email_address)
        userPhone = findViewById(R.id.text_view_user_phone_number)
    }
    fun getFullName():String {
        return "$title. $firstName $lastName"
    }
    private fun setValues() {
        title = intent.getStringExtra("title").toString()
        firstName = intent.getStringExtra("firstName").toString()
        lastName = intent.getStringExtra("lastName").toString()
        phone = intent.getStringExtra("phone").toString()
        email = intent.getStringExtra("email").toString()
        password = intent.getStringExtra("password").toString()
    }
    private fun displayUser() {
        userFullName.text = getFullName()
        userEmail.text = email
        userPhone.text = phone
    }
    private fun clickListener() {
        userEmail.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_SENDTO)
            myIntent.data = Uri.parse("mailto:$email")
            startActivity(myIntent)
        }
        userPhone.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_DIAL)
            myIntent.data = Uri.parse("tel:$phone")
            startActivity(myIntent)
        }
    }
}