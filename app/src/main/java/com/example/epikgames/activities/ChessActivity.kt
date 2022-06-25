package com.example.epikgames.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.epikgames.R
import com.github.bhlangonijr.chesslib.Board

class ChessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chess)

        val board: Board = Board()
        println(board.toString())
    }
}