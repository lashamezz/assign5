package com.android.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmail : EditText
    private lateinit var inputPassword : EditText
    private lateinit var submitButton: Button


    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEmail = findViewById(R.id.signInEmail)
        inputPassword = findViewById(R.id.signInPassword)
        submitButton = findViewById(R.id.submitButton)
        mAuth = FirebaseAuth.getInstance()

        submitButton.setOnClickListener {

            var email = inputEmail.text.toString()
            var password = inputPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()

            } else if(!email.contains("@")){
                Toast.makeText(this, "Please Provide Valid Email Address", Toast.LENGTH_SHORT).show()
            }
            else {

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{

                    Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show()

                    inputEmail.text.clear()
                    inputPassword.text.clear()

                }

            }

        }


    }

}