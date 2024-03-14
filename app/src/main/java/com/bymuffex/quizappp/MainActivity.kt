package com.bymuffex.quizappp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bymuffex.quizappp.databinding.ActivityMainBinding
import java.util.Queue

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var buttonS: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonS = findViewById(R.id.buttonStart)


        buttonS.setOnClickListener {
            val myIntent: Intent = Intent(
                this@MainActivity,
                quizq::class.java
            )
            myIntent.putExtra("key", android.R.attr.value) //Optional parameters

            this@MainActivity.startActivity(myIntent)
        }

    }
}