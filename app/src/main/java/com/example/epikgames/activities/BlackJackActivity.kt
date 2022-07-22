package com.example.epikgames.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
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