package com.example.epikgames.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.epikgames.R
import wordle.Board
import wordle.BoardController

class WordleFailureActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wordle_failure_pop_up)

        val playAgain: Button = findViewById(R.id.play_again)
        val quitGame: Button = findViewById(R.id.quit_game)
        playAgain.setOnClickListener {
            val intent = Intent(this,
                WordleActivity::class.java)
            startActivity(intent)
            println("EVENT HAPPENED")
        }

        quitGame.setOnClickListener {
            val intent = Intent(this,
                MainActivity::class.java)
            startActivity(intent)
            println("EVENT HAPPENED")

        }
    }
}