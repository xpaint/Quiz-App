package com.bymuffex.quizappp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bymuffex.quizappp.databinding.ActivityQuizqBinding
import kotlin.random.Random

class quizq : AppCompatActivity() {

    private lateinit var binding: ActivityQuizqBinding
    private lateinit var answer1: Button
    private lateinit var answer2: Button
    private lateinit var answer3: Button
    private lateinit var textViewQ: TextView
    private lateinit var textViewZ: TextView
    private var x = 0
    private var y = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizqBinding.inflate(layoutInflater)
        setContentView(binding.root)


        answer1 = findViewById(R.id.button1A)
        answer2 = findViewById(R.id.button2A)
        answer3 = findViewById(R.id.button3A)
        textViewQ = findViewById(R.id.textViewQ)
        textViewZ = findViewById(R.id.textViewZ)

        //val wrightList = arrayOf("Berlin", "Moskau", "London", "Washington", "Ottawa")
        val wrongList = arrayOf("Prag", "Sankt Petersburg", "Istanbul", "Paris", "NewYork", "LosAngeles", "Wales", "Manchester", "Toronto", "Quebeck")

        val buttons = arrayOf(answer1, answer2, answer3)

        var wrightbutton = buttons.random()

        fun whatIfT(){
            wrightbutton = buttons.random()
            if (x == 0) {
                wrightbutton.text = "Berlin"
            } else if (x == 1) {
                wrightbutton.text = "Moskau"
            } else if (x == 2) {
                wrightbutton.text = "London"
            } else if (x == 3) {
                wrightbutton.text = "Washington"
            } else if(x == 4){
                wrightbutton.text = "Ottawa"
            }
        }

        fun whatIfF(){
            answer1.text = wrongList.random()
            answer2.text = wrongList.random()
            answer3.text = wrongList.random()
        }

        whatIfF()
        whatIfT()


        answer1.setOnClickListener{
            if (answer1.text == wrightbutton.text){
                y++
                if(x<4){
                    ifButtonPressed()
                    whatIfF()
                    whatIfT()}else if (x >= 4){
                    ifButtonPressed()
                    answer2.text = "Retry"

                }
            }else{
                if(x<4){
                    ifButtonPressed()
                    whatIfF()
                    whatIfT()}else if (x >= 4){
                    ifButtonPressed()
                    answer2.text = "Retry"
                }
            }


        }
        answer2.setOnClickListener{
            if (answer2.text == wrightbutton.text){
                y++
               if(x<4){
                ifButtonPressed()
                                whatIfF()
                whatIfT()}else if (x >= 4){
                   ifButtonPressed()
                    answer2.text = "Retry"

               }
            }else{
                if(x<4){
                    ifButtonPressed()
                    whatIfF()
                    whatIfT()}else if (x >= 4){
                    ifButtonPressed()
                    answer2.text = "Retry"
                }
            }
        }
        answer3.setOnClickListener{
            if (answer3.text == wrightbutton.text){
                y++
                if(x<4){
                    ifButtonPressed()
                    whatIfF()
                    whatIfT()}else if (x >= 4){
                    ifButtonPressed()
                    answer2.text = "Retry"

                }
            }else{
                if(x<4){
                    ifButtonPressed()
                    whatIfF()
                    whatIfT()}else if (x >= 4){
                    ifButtonPressed()
                    answer2.text = "Retry"
                }
            }
        }
    }
    private fun ifButtonPressed(){
        if (x<4) {
            val questions = arrayOf(
                "Wie heißt die Hauptstadt von Russland?",
                "Wie heißt die Hauptstadt von England?",
                "Wie heißt die Hauptstadt der USA?",
                "Wie heißt die Hauptstadt von Kanada?"
            )
            var numb = arrayOf("2.", "3.", "4.", "5.")

            textViewQ.text = questions[x]
            textViewZ.text = numb[x]

            x++

        }else if (x >= 4) {
            textViewQ.text = "YOURE DONE!                      You've got: " + y +"/5"
            textViewZ.text = ""
            answer1.visibility = View.GONE
            answer3.visibility = View.GONE
            answer2.text = "Retry"
            answer2.setOnClickListener{
                val myIntent: Intent = Intent(
                    this@quizq,
                    MainActivity::class.java
                )
                myIntent.putExtra("key", android.R.attr.value) //Optional parameters

                this@quizq.startActivity(myIntent)
            }
            x++
        }
    }
}

