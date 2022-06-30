package com.example.epikgames.activities

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.gridlayout.widget.GridLayout
import chess.ChessController
import com.example.epikgames.R
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.BoardEventType
import com.github.bhlangonijr.chesslib.Piece

class ChessActivity : AppCompatActivity() {
    companion object {
        val board: Board = Board()
        val controller: ChessController = ChessController(Array(64) { it })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chess)

        val chessGrid = this.findViewById<GridLayout>(R.id.chess_grid)

        val dragListener = View.OnDragListener {view, e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> {
                    true
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> {
                    val item = e.clipData.getItemAt(0)
                    val dragData = item.text
                    if (dragData != null) {
                        Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()
                    }
                    view.invalidate()

                    val v = e.localState as View
                    val owner = v.parent as ViewGroup
                    val destination = view as LinearLayout

                    owner.removeView(v)
                    destination.addView(v)
                    controller.movePiece(board, owner.id, destination.id)

                    if (board.isMated) {
                        TODO()
                    }

                    if (board.isDraw) {
                        TODO()
                    }

                    if (board.isStaleMate) {
                        TODO()
                    }

                    drawBoard()
                    v.visibility = View.VISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }
                else -> {
                    false
                }
            }
        }


        for (i in 0..63) {
            val tile: ConstraintLayout = generateNewTile(i)
            val inTile: LinearLayout = tile.getChildAt(0) as LinearLayout
            inTile.setOnDragListener(dragListener)
            chessGrid.addView(tile)

            // Sets id so that 0 is in the bottom left corner
            inTile.id = (7 - i / 8) * 8 + i % 8

            val tilePiece = board.getPiece(controller.getSquare(inTile.id))

            if (tilePiece != Piece.NONE) {
                val text = TextView(this)
                text.text = tilePiece.fanSymbol
                text.textSize = 30f
                text.setTextColor(Color.RED)

                text.setOnLongClickListener {
                    text.setTextColor(Color.BLUE)
                    val clipText = text.text as String? + " moved"
                    val item = ClipData.Item(clipText)
                    val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
                    val data = ClipData(clipText, mimeTypes, item)

                    val dragShadowBuilder = View.DragShadowBuilder(it)

                    it.startDragAndDrop(data, dragShadowBuilder, it, 0)

                    it.visibility = View.INVISIBLE

                    true
                }

                inTile.addView(text)
                continue
            }

            val text = TextView(this)
            inTile.addView(text);
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

    private fun drawBoard() {
        for (i in 0..63) {
            val inTile = this.findViewById<LinearLayout>((7 - i / 8) * 8 + i % 8)
            inTile.removeAllViews()
            val tilePiece = board.getPiece(controller.getSquare(inTile.id))
            if (tilePiece != Piece.NONE) {
                val text = TextView(this)
                text.text = tilePiece.fanSymbol
                text.textSize = 30f
                text.setTextColor(Color.RED)

                text.setOnLongClickListener {
                    text.setTextColor(Color.BLUE)
                    val clipText = text.text as String? + " moved"
                    val item = ClipData.Item(clipText)
                    val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
                    val data = ClipData(clipText, mimeTypes, item)

                    val dragShadowBuilder = View.DragShadowBuilder(it)

                    it.startDragAndDrop(data, dragShadowBuilder, it, 0)

                    it.visibility = View.INVISIBLE

                    true
                }

                inTile.addView(text)
                continue
            }

            val text = TextView(this)
            inTile.addView(text);
        }
    }

    private fun generateNewTile(i: Int): ConstraintLayout {
        val tile: ConstraintLayout = layoutInflater.inflate(R.layout.chess_tile, null) as ConstraintLayout

        if ((i / 8 % 2 == 0 && i % 2 == 0) || (i / 8 % 2 == 1 && i % 2 == 1)) {
            tile.setBackgroundColor(Color.LTGRAY)
        } else {
            tile.setBackgroundColor(Color.BLACK)
        }

        return tile
    }
}