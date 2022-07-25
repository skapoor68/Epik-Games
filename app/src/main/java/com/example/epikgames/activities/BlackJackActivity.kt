package com.example.epikgames.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import blackjack.*
import com.example.epikgames.R
import wordle.Board
import java.util.*


class BlackJackActivity : AppCompatActivity() {

    companion object {
        val controller: GameController = GameController()
        var game: Game = controller.initGame("Player 1")
        var transitionQueue: Queue<GameTransition> = LinkedList()
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

        val hitButton = findViewById<Button>(R.id.hitButton)
        hitButton.setOnClickListener {
            controller.hit(game, transitionQueue)
            if (game.players[0].bank <= 0.0 && game.players[0].hands.size == 0) {
                loseDialog()
            } else {
                runTransitions()
            }

        }

        val standButton = findViewById<Button>(R.id.standButton)
        standButton.setOnClickListener {
            controller.stand(game)
            if (controller.roundOverForPlayers(game)) {
                controller.endRound(game, transitionQueue)
                if (game.players[0].bank <= 0.0 && game.players[0].hands.size == 0) {
                    loseDialog()
                } else {
                    runTransitions()
                }
            } else {
                runTransitions()
            }

        }

        if (game.players[0].bank <= 0.0 && game.players[0].hands.size == 0) {
            loseDialog()
        }


        val betButton = findViewById<Button>(R.id.betButton)
        betButton.setOnClickListener {
            if (game.getCurrentPlayer() != null && game.getCurrentPlayer()!!.hands.size == 0) {
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
                    if (betAmt > game.players[0].bank || betAmt == 0) {
                        Toast.makeText(this, "INVALID BET", Toast.LENGTH_SHORT).show()
                        betAmt = 0
                    } else {
                        controller.placeBet(game.players[0], betAmt)
                        controller.dealFirstRound(game, transitionQueue)
                        val intent = Intent(
                            this,
                            BlackJackActivity::class.java
                        )
                        startActivity(intent)
                    }
                }

                val clear: Button = dialogView.findViewById(R.id.clear)
                clear.setOnClickListener {
                    betAmt = 0;
                    betAmountText.text = "Bet Amount: ".plus(betAmt)
                }

                //quit(go back) button on the alert
                val quit: Button = dialogView.findViewById(R.id.go_back)
                quit.setOnClickListener {
                    val intent = Intent(
                        this,
                        BlackJackActivity::class.java
                    )
                    startActivity(intent)
                }

                alert.create()
                alert.show()
            }
        }

        if (!transitionQueue.isEmpty()) {
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
                params.setMargins(0, -400 + margin, 0, 0)
                image.layoutParams = params
                margin += 250
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
                    params.setMargins(0, -400 + margin, 0, 0)
                    image.layoutParams = params
                    margin += 250
                }
            }
        }

        val betAmountText = this.findViewById<TextView>(R.id.betAmount)
        val balanceText = this.findViewById<TextView>(R.id.amount)

        if (player.hands.size > 0) {
            betAmountText.text = "$" + player.hands[0].betAmount
        } else {
            betAmountText.text = "$0"
        }

        balanceText.text = "$" + player.bank
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
                if (!transitionQueue.isEmpty()) {
                    val transition = transitionQueue.remove()
                    val handler = Handler(Looper.getMainLooper())
                    handler.post { drawBoard(transition.game) }
                }
            }
        }

        Thread(runnable).start()
    }

    private fun loseDialog() {
            val alert = AlertDialog.Builder(this)
            val dialogView: View = layoutInflater.inflate(R.layout.player_wins, null)
            alert.setView(dialogView)

            val playerWins = dialogView.findViewById<TextView>(R.id.playerWinsView)
            playerWins.textSize = 30F
            playerWins.text = "YOU LOST!"

            val playAgain: Button = dialogView.findViewById(R.id.play_again)

            playAgain.setOnClickListener {
                val intent = Intent(
                    this,
                    BlackJackActivity::class.java
                )
                game = Game()
                game = controller.initGame("Player 1")
                transitionQueue = LinkedList()
                startActivity(intent)
            }

            val quitGame: Button = dialogView.findViewById(R.id.quit_game)
            quitGame.setOnClickListener {
                val intent = Intent(
                    this,
                    MainActivity::class.java
                )
                startActivity(intent)
            }
            alert.create()
            alert.show()
    }
}