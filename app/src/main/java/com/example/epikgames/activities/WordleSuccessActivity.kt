package com.example.epikgames.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.recreate
import com.example.epikgames.R

class WordleSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wordle_success_pop_up)

        val playAgain: Button = findViewById(R.id.play_again)
        val quitGame: Button = findViewById(R.id.quit_game)
        playAgain.setOnClickListener {
            val intent = Intent(this,
                WordleActivity::class.java)
            startActivity(intent)
        }

        quitGame.setOnClickListener {
            val intent = Intent(this,
                MainActivity::class.java)
            startActivity(intent)
        }
    }
}

