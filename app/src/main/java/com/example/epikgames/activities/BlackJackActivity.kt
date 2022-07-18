package com.example.epikgames.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.epikgames.R

class BlackJackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blackjack)

        val rulesButton = findViewById<ImageButton>(R.id.blackjackRules)
        rulesButton.setOnClickListener {
            val intent = Intent(this, BlackJackRulesActivity::class.java)
            startActivity(intent)
        }
    }
}