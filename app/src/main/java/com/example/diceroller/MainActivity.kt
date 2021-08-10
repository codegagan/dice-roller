package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {rollDice() }
        rollDice()

    }

    private fun rollDice() {
        val makeText = Toast.makeText(this, "Dice rolled !!", Toast.LENGTH_SHORT)
        makeText.show()

        val imageView = findViewById<ImageView>(R.id.imageView)
        val dice = Dice(6)
        val diceValue = dice.roll()

        val diceImage = when(diceValue){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
        imageView.setImageResource(diceImage)

        imageView.contentDescription = diceValue.toString()

    }
}


class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}