package com.jabustillo.navigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_pair_memory_game.*

class PairMemoryGame : AppCompatActivity() {
    val pairsNumber : Int = 6
    var first : Int = 0
    var second : Int = 0
    var firstIV : Int = 0
    var score: Int = 0
    var streak: Int = 1

    val waifusArray = arrayOf(R.drawable.w11, R.drawable.w21, R.drawable.w31, R.drawable.w41, R.drawable.w51, R.drawable.w61)

    var tuples = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    var completed = arrayOf(0, 0, 0, 0, 0, 0)
    var completedIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pair_memory_game)
        setWaifus()

        val objectIntent : Intent = intent
        score = objectIntent.getIntExtra("score", 1)

        val tvScore : TextView = findViewById(R.id.tvScore)
        tvScore.text = score.toString()
    }

    override fun onBackPressed() {
        val goBack : Intent = Intent(this,MainActivity::class.java)
        goBack.putExtra("score", score)
        setResult(Activity.RESULT_OK, goBack)
        println(0)
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setWaifus() {
        var temp = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).toList()

        for (i in 1..pairsNumber) {
            var algo = temp.random().toInt()
            temp = temp.filter { it != algo }

            tuples[algo-1] = i

            algo = temp.random().toInt()
            temp = temp.filter { it != algo }

            tuples[algo-1] = i
        }
    }

    fun power(i: Int, iv: ImageView) {
        if (!completed.contains(tuples[i]) && second == 0) {
            iv.setImageResource(waifusArray[tuples[i]-1])

            if (first != 0) {
                second = tuples[i]

                if (first == second) {
                    completed.set(completedIndex, tuples[i])
                    completedIndex++
                    score += 100*streak
                    streak++
                } else {
                    GlobalScope.launch(context = Dispatchers.Main) {
                        delay(2000)
                        // code here
                        when(firstIV) {
                            1 -> iv1.setImageResource(R.drawable.question)
                            2 -> iv2.setImageResource(R.drawable.question)
                            3 -> iv3.setImageResource(R.drawable.question)
                            4 -> iv4.setImageResource(R.drawable.question)
                            5 -> iv5.setImageResource(R.drawable.question)
                            6 -> iv6.setImageResource(R.drawable.question)
                            7 -> iv7.setImageResource(R.drawable.question)
                            8 -> iv8.setImageResource(R.drawable.question)
                            9 -> iv9.setImageResource(R.drawable.question)
                            10 -> iv10.setImageResource(R.drawable.question)
                            11 -> iv11.setImageResource(R.drawable.question)
                            12 -> iv12.setImageResource(R.drawable.question)
                        }
                        iv.setImageResource(R.drawable.question)
                    }
                    streak = 1
                }

                val tvScore : TextView = findViewById(R.id.tvScore)
                tvScore.text = score.toString()
                first = 0
                second = 0
            } else {
                first = tuples[i]
                firstIV = i+1
            }
        }
    }

    fun showPic1(view: View) {
        power(0, iv1)
    }

    fun showPic2(view: View) {
        power(1, iv2)
    }

    fun showPic3(view: View) {
        power(2, iv3)
    }

    fun showPic4(view: View) {
        power(3, iv4)
    }

    fun showPic5(view: View) {
        power(4, iv5)
    }

    fun showPic6(view: View) {
        power(5, iv6)
    }

    fun showPic7(view: View) {
        power(6, iv7)
    }

    fun showPic8(view: View) {
        power(7, iv8)
    }

    fun showPic9(view: View) {
        power(8, iv9)
    }

    fun showPic10(view: View) {
        power(9, iv10)
    }

    fun showPic11(view: View) {
        power(10, iv11)
    }

    fun showPic12(view: View) {
        power(11, iv12)
    }

    fun reset(view: View) {
        iv1.setImageResource(R.drawable.question)
        iv2.setImageResource(R.drawable.question)
        iv3.setImageResource(R.drawable.question)
        iv4.setImageResource(R.drawable.question)
        iv5.setImageResource(R.drawable.question)
        iv6.setImageResource(R.drawable.question)
        iv7.setImageResource(R.drawable.question)
        iv8.setImageResource(R.drawable.question)
        iv9.setImageResource(R.drawable.question)
        iv10.setImageResource(R.drawable.question)
        iv11.setImageResource(R.drawable.question)
        iv12.setImageResource(R.drawable.question)
        setWaifus()
        completed = arrayOf(0, 0, 0, 0, 0, 0)
        completedIndex = 0
        streak = 1
        val tvScore : TextView = findViewById(R.id.tvScore)
        tvScore.text = score.toString()
    }
}