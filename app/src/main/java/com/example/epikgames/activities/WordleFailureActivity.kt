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
    private val boardC = BoardController()
    private val board = Board(solution = boardC.getRandWord())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wordle_failure_pop_up)
        val failureView = findViewById<TextView>(R.id.failureTextView)
        failureView.text = "Sorry! You ran out of guesses. The word was ${board.solution}"

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