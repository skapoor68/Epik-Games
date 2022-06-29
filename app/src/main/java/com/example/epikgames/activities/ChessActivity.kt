package com.example.epikgames.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.gridlayout.widget.GridLayout
import chess.ChessController
import com.example.epikgames.R
import com.github.bhlangonijr.chesslib.Board

class ChessActivity : AppCompatActivity() {
    val board: Board = Board()
    val controller: ChessController = ChessController(Array(64) { it })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chess)

        val chessGrid = this.findViewById<GridLayout>(R.id.chess_grid)

        for (i in 0..63) {
            val tile: View = generateNewTile(i)
            chessGrid.addView(tile)

            // Sets id so that 0 is in the bottom left corner
            tile.id = (7 - i / 8) * 8 + i % 8
        }



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

    private fun generateNewTile(i: Int): View {
        val tile: View = layoutInflater.inflate(R.layout.chess_tile, null)

        if ((i / 8 % 2 == 0 && i % 2 == 0) || (i / 8 % 2 == 1 && i % 2 == 1)) {
            tile.setBackgroundColor(Color.LTGRAY)
        } else {
            tile.setBackgroundColor(Color.BLACK)
        }

        return tile
    }
}