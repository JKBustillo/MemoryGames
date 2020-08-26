package com.jabustillo.navigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var score : Int = 0 // Global score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // function to summon the pair match game and pass the score
        btnPair.setOnClickListener {
            val intent: Intent = Intent(this, PairMemoryGame::class.java)
            intent.putExtra("score", score)
            startActivityForResult(intent, 1)
        }

        // function to summon the second memory game and pass the score
        btnMemory.setOnClickListener {
            val intent: Intent = Intent(this, MemoryGame::class.java)
            intent.putExtra("score", score)
            startActivityForResult(intent, 1)
        }
    }

    // Receive the score from both games
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            score = data!!.getIntExtra("score", 1) // set the new global score
            tvScore.setText(data!!.getIntExtra("score", 1).toString()) // show the new global score
        }
    }
}