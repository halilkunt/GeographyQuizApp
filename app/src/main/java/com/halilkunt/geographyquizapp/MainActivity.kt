package com.halilkunt.geographyquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun startQuiz(view : View){
        val intent = Intent(this,QuizQuestionsActivity::class.java)
        startActivity(intent)
        finish()
    }

}