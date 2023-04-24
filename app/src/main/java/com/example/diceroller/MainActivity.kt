package com.example.diceroller


import Dice
import EightDice
import FourDice
import SixDice
import TwelveDice
import TwentyDice
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val fourDice: Button = findViewById(R.id.button2)
        val sixDice: Button = findViewById(R.id.button3)
        val eightDice: Button = findViewById(R.id.button4)
        val twelveDice: Button = findViewById(R.id.button5)
        val twentyDice: Button = findViewById(R.id.button6)
        fourDice.setOnClickListener { diceChoiceFour()}
        sixDice.setOnClickListener { diceChoiceSix()}
        eightDice.setOnClickListener { diceChoiceEight()}
        twelveDice.setOnClickListener { diceChoiceTwelve()}
        twentyDice.setOnClickListener { diceChoiceTwenty()}
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    //TODO find drawables for each dice variation and just update the app to support all standard D&D dice

    private var dice: Dice = SixDice()
    private fun diceChoiceFour() {
        this.dice = FourDice()
    }
    private fun diceChoiceEight() {
        this.dice = EightDice()
    }
    private fun diceChoiceTwelve() {
        this.dice = TwelveDice()
    }
    private fun diceChoiceTwenty() {
        this.dice = TwentyDice()
    }
    private fun diceChoiceSix() {
        this.dice = SixDice()
    }

    private fun rollDice() {
        val diceRoll = dice.roll()
        // changing image
        val diceImage: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView)
        if (dice != SixDice()){
            diceImage.visibility = View.INVISIBLE
            textView.text = diceRoll.toString()
        }
        diceImage.contentDescription = diceRoll.toString()
    }
}