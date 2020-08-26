package com.jabustillo.navigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPair.setOnClickListener {
            val intent: Intent = Intent(this, PairMemoryGame::class.java)
            intent.putExtra("score", score)
            startActivityForResult(intent, 1)
        }

        btnMemory.setOnClickListener {
            val intent: Intent = Intent(this, MemoryGame::class.java)
            intent.putExtra("score", score)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            score = data!!.getIntExtra("score", 1)
            tvScore.setText(data!!.getIntExtra("score", 1).toString())
        }
    }
}