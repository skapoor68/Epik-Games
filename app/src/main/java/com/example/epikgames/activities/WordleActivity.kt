package com.example.epikgames.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.marginLeft
import androidx.core.view.setPadding
import com.example.epikgames.R
import wordle.Board

const val keyWidth = 95
const val keyHeight = 130

class WordleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val Board = Board()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wordle)


        val wordleGrid: androidx.gridlayout.widget.GridLayout = this.findViewById(R.id.wordle_grid)

        for (tile in Board.tileArray) {
            val tileView: View = layoutInflater.inflate(R.layout.wordle_tile, null)
            tileView.id = tile.id
            wordleGrid.addView(tileView)
        }

        val keyboardRowOne: LinearLayout = this.findViewById(R.id.keyboard_row_1)

        for (ch in "QWERTYUIOP") {
            val button: Button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(keyWidth, keyHeight)
            button.text = ch.toString()
            button.id = ch.hashCode()
            keyboardRowOne.addView(button)
        }

        val keyboardRowTwo: LinearLayout = this.findViewById(R.id.keyboard_row_2)

        for (ch in "ASDFGHJKL") {
            val button: Button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(keyWidth, keyHeight)
            button.text = ch.toString()
            button.id = ch.hashCode()
            keyboardRowTwo.addView(button)
        }

        val keyboardRowThree: LinearLayout = this.findViewById(R.id.keyboard_row_3)

        val enterButton: Button = Button(this)
        enterButton.layoutParams = LinearLayout.LayoutParams(2 * keyWidth, keyHeight)
        enterButton.text = "Enter"
        enterButton.id = "Enter".hashCode()
        keyboardRowThree.addView(enterButton)

        for (ch in "ZXCVBNM") {
            val button: Button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(keyWidth, keyHeight)
            button.text = ch.toString()
            button.id = ch.hashCode()
            keyboardRowThree.addView(button)
        }

        val backButton: Button = Button(this)
        backButton.layoutParams = LinearLayout.LayoutParams(2 * keyWidth, keyHeight)
        backButton.text = "Back"
        backButton.id = "Back".hashCode()
        keyboardRowThree.addView(backButton)

    }
}