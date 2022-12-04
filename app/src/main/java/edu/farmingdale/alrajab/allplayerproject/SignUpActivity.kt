package edu.farmingdale.alrajab.allplayerproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {

            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            val confirmPass = binding.cpasswordEt.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (password == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful)
                    }
                }
            } else
                Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
        }
    }
    else{
            Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
        }
    }
