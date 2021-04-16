package com.example.mychittor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var editText: EditText
    private fun signup(){


        var userText : EditText = findViewById(R.id.InputEmail)
        var passText : EditText = findViewById(R.id.InputPassword)
        val email : Editable? = userText.getText()
        val password : Editable? = passText.getText()

        auth = FirebaseAuth.getInstance()


        auth.createUserWithEmailAndPassword(email.toString(), password.toString()).addOnCompleteListener(this, OnCompleteListener{ task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Registration Failed"+ task.exception!!.message, Toast.LENGTH_LONG).show()
            }
        })

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
//
//        var userText : EditText = findViewById(R.id.InputEmail)
//        var passText : EditText = findViewById(R.id.InputPassword)
//        val email : Editable? = userText.getText()
//        val password : Editable? = passText.getText()
        val button : Button = findViewById(R.id.signup)
        val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent2 = Intent(this, LoginActivity::class.java)
            startActivity(intent2)
        }

        button.setOnClickListener { signup() }

    }
}