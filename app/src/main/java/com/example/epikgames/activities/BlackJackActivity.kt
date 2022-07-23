package com.example.epikgames.activities

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.epikgames.R

import blackjack.CardImages
import blackjack.Game
import blackjack.GameController
import blackjack.Player

class BlackJackActivity : AppCompatActivity() {

    var controller: GameController = GameController()
    var player1: Player = Player("Some rando") //can be modified

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blackjack)

        startGame()

        //This can be changed
        controller.initGame("Some ranoo")

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

            var betAmt = 0
            val alert: AlertDialog.Builder = AlertDialog.Builder(this)
            val dialogView: View = layoutInflater.inflate(R.layout.betting_popup, null)
            alert.setView(dialogView)

            val betView = dialogView.findViewById<TextView>(R.id.betTextView)
            betView.textSize = 25F
            betView.text = "PLACE BETS"

            val betAmountText = dialogView.findViewById<TextView>(R.id.betPopUpAmount)

            val bet2: ImageView = dialogView.findViewById(R.id.chip2)
            bet2.setOnClickListener {
                betAmt += 2
                betAmountText.text = "Bet Amount: ".plus(betAmt)
            }

            val bet10: ImageView = dialogView.findViewById(R.id.chip10)
            bet10.setOnClickListener {
                betAmt += 10
                betAmountText.text = "Bet Amount: ".plus(betAmt)
            }

            val bet25: ImageView = dialogView.findViewById(R.id.chip25)
            bet25.setOnClickListener {
                betAmt += 25
                betAmountText.text = "Bet Amount: ".plus(betAmt)
            }

            val bet100: ImageView = dialogView.findViewById(R.id.chip100)
            bet100.setOnClickListener {
                betAmt += 100
                betAmountText.text = "Bet Amount: ".plus(betAmt)
            }
            //place bet button on the alert
            val placeBet: Button = dialogView.findViewById(R.id.place_bet)
            placeBet.setOnClickListener {

                controller.placeBet(player1, betAmt)
                val intent = Intent(this,
                    BlackJackActivity::class.java)
                startActivity(intent)
            }

            //clear button on the alert
            val clear: Button = dialogView.findViewById(R.id.clear)
            clear.setOnClickListener {
                betAmt = 0;
                betAmountText.text = "Bet Amount: ".plus(betAmt)
            }

            //quit(go back) button on the alert
            val quit: Button = dialogView.findViewById(R.id.go_back)
            quit.setOnClickListener {
                val intent = Intent(this,
                    BlackJackActivity::class.java)
                startActivity(intent)
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