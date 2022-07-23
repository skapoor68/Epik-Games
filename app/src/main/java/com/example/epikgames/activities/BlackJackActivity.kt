package com.example.epikgames.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import blackjack.CardImages
import blackjack.Game
import blackjack.GameController
import blackjack.GameTransition
import com.example.epikgames.R
import java.util.*


class BlackJackActivity : AppCompatActivity() {

    companion object {
        val controller: GameController = GameController()
        val game: Game = controller.initGame("Player 1")
        val transitionQueue: Queue<GameTransition> = LinkedList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blackjack)

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



        if (game.players[0].hands.size == 0) {
            controller.placeBet(game.players[0], 10)
            controller.dealFirstRound(game, transitionQueue)

            for (transition in transitionQueue) {
                println(transition.game.players[0].hands[0])
            }
            runTransitions()
        } else {
            drawBoard(game)
        }


    }

    private fun drawBoard(game: Game) {
        val cardImages = CardImages

        val dealer = game.dealer
        val player = game.players[0]

        val dealerCards = this.findViewById<RelativeLayout>(R.id.dealerCards)
        val playerCards = this.findViewById<RelativeLayout>(R.id.playerCards)

        dealerCards.removeAllViews()
        playerCards.removeAllViews()

        var margin = 0

        for (card in dealer.hand.cards) {
            val resource: Int? = if (card.faceUp) cardImages.getCardResource(card.suite, card.rank) else
                R.drawable.flipped_card
            if (resource != null) {
                val image = ImageView(this)
                image.setImageResource(resource)
                dealerCards.addView(image)
                val params = RelativeLayout.LayoutParams(image.layoutParams)
                params.setMargins(0, margin, 0, 0)
                image.layoutParams = params
                margin += 200
            }
        }

        margin = 0

        if (player.hands.size > 0) {
            for (card in player.hands[0].cards) {
                val resource: Int? = if (card.faceUp) cardImages.getCardResource(card.suite, card.rank) else
                    R.drawable.flipped_card
                if (resource != null) {
                    val image = ImageView(this)
                    image.setImageResource(resource)
                    playerCards.addView(image)
                    val params = RelativeLayout.LayoutParams(image.layoutParams)
                    params.setMargins(0, margin, 0, 0)
                    image.layoutParams = params
                    margin += 200
                }
            }
        }
    }

    private fun runTransitions() {
        // Do something long
        val runnable = Runnable {
            while (!transitionQueue.isEmpty()) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val transition = transitionQueue.remove()
                val handler = Handler(Looper.getMainLooper())
                handler.post { drawBoard(transition.game) }
            }
        }

        Thread(runnable).start()
    }
}