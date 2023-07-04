package com.example.evcilhayvanapp.view

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.evcilhayvanapp.R
import com.example.evcilhayvanapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
   private lateinit var auth : FirebaseAuth
   private lateinit var imageview :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
      // imageview=binding.mygif
        setContentView(view)

        //private lateinit val imageview :ImageView =binding.mygif
       // Glide.with(this).load(R.drawable.baykus).into(imageview)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser!=null){
            val intent =Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun signInClicked(view : View)
    {
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()
        if(email.equals("")|| password.equals("")){
            Toast.makeText(this,"Enter Email and Password", Toast.LENGTH_SHORT).show()
        }else{
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            } } }
    fun signUpClicked(view : View) {
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()
        if (email.equals("") || password.equals("")) {

            Toast.makeText(this, "Enter Email and Password !", Toast.LENGTH_LONG).show()

        } else {

            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
}

