package com.jabustillo.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPair.setOnClickListener {
            val intent: Intent = Intent(this, PairMemoryGame::class.java)
            startActivity(intent)
        }

        btnMemory.setOnClickListener {
            val intent: Intent = Intent(this, MemoryGame::class.java)
            startActivity(intent)
        }
    }
}