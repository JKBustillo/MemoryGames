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
    val pairsNumber : Int = 6 // six pairs of images
    var first : Int = 0 // first image selected
    var second : Int = 0 // second image selected
    var firstIV : Int = 0 // aux val
    var score: Int = 0
    var streak: Int = 1 // streak of good guesses

    // arrays with the 6 images
    val waifusArray = arrayOf(R.drawable.w11, R.drawable.w21, R.drawable.w31, R.drawable.w41, R.drawable.w51, R.drawable.w61)

    var tuples = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) // array to save the images
    var completed = arrayOf(0, 0, 0, 0, 0, 0) // // array to save the pairs guessed
    var completedIndex = 0 // number to control the compteted array

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pair_memory_game)
        setWaifus() // set the images at the start

        // get the value from the parent
        val objectIntent : Intent = intent
        score = objectIntent.getIntExtra("score", 1)

        val tvScore : TextView = findViewById(R.id.tvScore)
        tvScore.text = score.toString()
    }

    // function when you go back with the button of the phone and pass the score
    override fun onBackPressed() {
        val goBack : Intent = Intent(this,MainActivity::class.java)
        goBack.putExtra("score", score)
        setResult(Activity.RESULT_OK, goBack)
        println(0)
        super.onBackPressed()
    }

    // function when you go back with the button in the appbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    // set the images random in the board
    fun setWaifus() {
        var temp = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).toList() // array for every position

        for (i in 1..pairsNumber) {
            var algo = temp.random().toInt() // get a random position
            temp = temp.filter { it != algo } // delete a occupied position

            tuples[algo-1] = i // save the images in its position

            algo = temp.random().toInt()
            temp = temp.filter { it != algo } // delete a occupied position

            // two times for every pair (obviously)

            tuples[algo-1] = i // save the images in its position
        }
    }

    // function that triggers when you select a picture
    fun power(i: Int, iv: ImageView) {
        if (!completed.contains(tuples[i]) && second == 0) { // verify if there's a images displayed here and
            iv.setImageResource(waifusArray[tuples[i]-1])

            if (first != 0) { // verify if you already pick one
                second = tuples[i] // set the image for the second choice

                if (first == second) { // verify if the images match
                    completed.set(completedIndex, tuples[i]) // add the image to the completed array
                    completedIndex++
                    score += 100*streak // score up!
                    streak++ // streak up!
                } else { // if the images don't match
                    GlobalScope.launch(context = Dispatchers.Main) {
                        delay(2000)
                        // delay 2 seconds
                        when(firstIV) { // set the first choice to default
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
                        iv.setImageResource(R.drawable.question) // set the current/second choice to default
                    }
                    streak = 1 // reset the streak
                }

                val tvScore : TextView = findViewById(R.id.tvScore)
                tvScore.text = score.toString() // show the new score
                first = 0 // reset the two choices
                second = 0 // reset the two choices
            } else {
                first = tuples[i] // set the first choice
                firstIV = i+1 // save the number of the imageview for the first choice
            }
        }
    }

    // show the pic in every position
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

    // reset every value
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
    }
}