package com.example.epikgames.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.epikgames.R

class WordleRulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chess_rules_activity)

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener() {
            finish()
        }
    }
}