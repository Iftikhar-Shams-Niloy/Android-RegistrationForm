package com.example.myformapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerPersonTitle: Spinner
    private lateinit var materialButtonCreateAccount: MaterialButton
    private lateinit var editTextFirstName: TextInputEditText
    private lateinit var editTextLastName: TextInputEditText
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPhoneNumber: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerPersonTitle = findViewById(R.id.spinner_person_title)
        materialButtonCreateAccount = findViewById(R.id.material_button_create_account)
        editTextFirstName = findViewById(R.id.text_input_edit_text_first_name)
        editTextLastName = findViewById(R.id.text_input_edit_text_last_name)
        editTextEmail = findViewById(R.id.text_input_edit_text_email)
        editTextPhoneNumber = findViewById(R.id.text_input_edit_text_phone_number)
        editTextPassword = findViewById(R.id.text_input_edit_text_password)

        setupSpinner()
        setupButton()
    }
    private fun setupSpinner() {
        val personTitlesArray = arrayOf("Miss","Mr","Mrs","Ms","Mx","Dr","Md","Prof")
        val personTitleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, personTitlesArray)
        spinnerPersonTitle.adapter = personTitleAdapter
    }
    private fun setupButton() { // This function only runs the function createAccount on BUTTON press
        materialButtonCreateAccount.setOnClickListener{
           createAccount()
        }
    }
    private fun createAccount(){

        val myIntent = Intent(this,SummaryActivity::class.java)

        myIntent.putExtra("title",        spinnerPersonTitle.selectedItem as String)
        myIntent.putExtra("firstName",    editTextFirstName.text.toString())
        myIntent.putExtra("lastName",     editTextLastName.text.toString())
        myIntent.putExtra("email",        editTextEmail.text.toString())
        myIntent.putExtra("phone",        editTextPhoneNumber.text.toString())
        myIntent.putExtra("password",     editTextPassword.text.toString())

        startActivity(myIntent)

    }
}