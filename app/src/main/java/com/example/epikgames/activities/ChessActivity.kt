package com.example.epikgames.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.epikgames.R
import com.github.bhlangonijr.chesslib.Board

class ChessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chess)

        val board: Board = Board()
        println(board.toString())
        
        //exit button
        val exitButton = findViewById<ImageButton>(R.id.chessExitButton)
        exitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // TODO
//    val rulesButton = findViewById<ImageButton>(R.id.chessRulesButton)
//    rulesButton.setOnClickListener {
//        val intent = Intent(this, WordleRulesActivity::class.java)
//        startActivity(intent)
//    }
    }
}