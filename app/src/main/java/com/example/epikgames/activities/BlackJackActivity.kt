package com.example.epikgames.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.epikgames.R

import blackjack.CardImages

class BlackJackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blackjack)

        startGame()

        val rulesButton = findViewById<ImageButton>(R.id.blackjackRules)
        rulesButton.setOnClickListener {
            val intent = Intent(this, BlackJackRulesActivity::class.java)
            startActivity(intent)
        }

        val exitButton = findViewById<ImageButton>(R.id.blackjackExit)
        exitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val betButton = findViewById<Button>(R.id.betButton)
        betButton.setOnClickListener {
            val alert: AlertDialog.Builder = AlertDialog.Builder(this)
            val dialogView: View = layoutInflater.inflate(R.layout.betting_popup, null)
            alert.setView(dialogView)

            val betView = dialogView.findViewById<TextView>(R.id.betTextView)
            betView.textSize = 25F
            betView.text = "PLACE BETS"

            //place bet button on the alert
            val placeBet: Button = dialogView.findViewById(R.id.place_bet)
            placeBet.setOnClickListener {
                val intent = Intent(this,
                    ChessActivity::class.java)


            }

            //clear button on the alert
            val clear: Button = dialogView.findViewById(R.id.clear)
            clear.setOnClickListener {
                val intent = Intent(this,
                    MainActivity::class.java)
            }

            //quit(go back) button on the alert
            val quit: Button = dialogView.findViewById(R.id.go_back)
            quit.setOnClickListener {
                val intent = Intent(this,
                    MainActivity::class.java)
            }

            alert.create()
            alert.show()
        }
    }

    private fun startGame() {
        val cardImages = CardImages

        val dealerCard2 = this.findViewById<ImageView>(R.id.dealerCard2)
        dealerCard2.setImageResource(cardImages.getRandomCard())

        val playerCard1 = this.findViewById<ImageView>(R.id.playerCard1)
        playerCard1.setImageResource(cardImages.getRandomCard())

        val playerCard2 = this.findViewById<ImageView>(R.id.playerCard2)
        playerCard2.setImageResource(cardImages.getRandomCard())
    }
}