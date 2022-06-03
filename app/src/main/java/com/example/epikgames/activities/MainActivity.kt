package com.example.epikgames.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.epikgames.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordleButton: Button = findViewById(R.id.wordle_button)
        val chessButton: Button = findViewById(R.id.chess_button)
        val blackJackButton: Button = findViewById(R.id.blackjack_button)
        val teamInfoButton: Button = findViewById(R.id.team_info_button)
        val quitButton: Button = findViewById(R.id.quit_button)

        wordleButton.setOnClickListener(this)
        chessButton.setOnClickListener(this)
        blackJackButton.setOnClickListener(this)
        teamInfoButton.setOnClickListener(this)
        quitButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.wordle_button -> {
                val intent = Intent(this,
                    WordleActivity::class.java)
                startActivity(intent)
            }
            R.id.chess_button -> {
                val intent = Intent(this,
                    ChessActivity::class.java)
                startActivity(intent)
            }
            R.id.blackjack_button -> {
                val intent = Intent(this,
                    BlackJackActivity::class.java)
                startActivity(intent)
            }
            R.id.team_info_button -> run {
                val alert: AlertDialog.Builder = AlertDialog.Builder(this)
                val dialogView: View = layoutInflater.inflate(R.layout.main_popup_team_info, null)

                alert.setView(dialogView)
                alert.create()
                alert.show()
            }
            R.id.quit_button -> {
                TODO()
            }
        }
    }

}