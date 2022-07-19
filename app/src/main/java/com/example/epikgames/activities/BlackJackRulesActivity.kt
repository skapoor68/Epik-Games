package com.example.epikgames.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.epikgames.R

class BlackJackRulesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blackjack_rules)

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener() {
            finish()
        }
    }
}