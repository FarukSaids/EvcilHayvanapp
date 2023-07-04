package com.example.evcilhayvanapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.evcilhayvanapp.view.SplashScreen


class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val animal =intent.getParcelableExtra<animalsdata>("animals")
        if(animal != null){
            val TextView : TextView = findViewById(R.id.hayvandetay)
            val ImageView : ImageView = findViewById(R.id.hayvanresim)
            val TextView1 : TextView = findViewById(R.id.hayvanbilgi1)

            TextView.text=animal.title
            ImageView.setImageResource(animal.logo)
            TextView1.text=animal.bilgiler
        }
    }
}