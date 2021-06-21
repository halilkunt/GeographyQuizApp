package com.halilkunt.geographyquizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var score: Int = 0
    private var level: Int = 1
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()


        sharedPreferences = this.getSharedPreferences("com.halilkunt.geographyquizapp", Context.MODE_PRIVATE)

        if(sharedPreferences.getInt("levelBilgisi", 1) == null){
            level = 1
        }else{
           level = sharedPreferences.getInt("levelBilgisi", 1)
        }
        if(sharedPreferences.getInt("scoreBilgisi", 1) == null){
            score = 0
        }else{
            score = sharedPreferences.getInt("scoreBilgisi", 0)
        }
        if(sharedPreferences.getInt("currentPosition", 1) == null){
            mCurrentPosition = 1
        }else{
            mCurrentPosition = sharedPreferences.getInt("currentPosition", 1)
        }

        setQuestion()

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        submitBtn.setOnClickListener(this)

    }

    override fun onStop() {
        super.onStop()
        sharedPreferences.edit().putInt("levelBilgisi", level).apply()
        sharedPreferences.edit().putInt("scoreBilgisi", score).apply()
        sharedPreferences.edit().putInt("currentPosition", mCurrentPosition).apply()

    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        mSelectedOptionPosition = 0

        if(score >= 100){
            level++
            score -= 100
        }
        levelTV.text = "LEVEL $level"

        progressBar.setProgress(score)

        if(mCurrentPosition == mQuestionsList!!.size){
            submitBtn.text = "FINISH"
        }else{
            submitBtn.text = "SUBMIT"
        }

        questionText.text = question!!.question
        questionImage.setImageResource(question.image)
        if(question.image == R.drawable.emptyimage){
            questionImage.visibility = View.GONE
        }else{
            questionImage.visibility = View.VISIBLE
        }
        opt1.text = question.optionOne
        opt2.text = question.optionTwo
        opt3.text = question.optionThree
        opt4.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(opt1)
        options.add(opt2)
        options.add(opt3)
        options.add(opt4)

        for(option in options){
            option.setTextColor(Color.parseColor("#042C33"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.opt1 -> selectedOptionView(opt1, 1)
            R.id.opt2 -> selectedOptionView(opt2, 2)
            R.id.opt3 -> selectedOptionView(opt3, 3)
            R.id.opt4 -> selectedOptionView(opt4, 4)

            R.id.submitBtn -> {
                if (mSelectedOptionPosition == 0) {
                    Toast.makeText(this, "Please choose an option, or to pass the question click again the submit button", Toast.LENGTH_LONG).show()
                    mSelectedOptionPosition = -1
                } else if (mSelectedOptionPosition == -1) {
                    mSelectedOptionPosition = 0
                    mCurrentPosition++

                    if (mCurrentPosition <= mQuestionsList!!.size) setQuestion()
                    else if(mCurrentPosition == mQuestionsList!!.size + 1){
                        val intent = Intent(this,FinishActivity::class.java)
                        sharedPreferences.edit().putInt("levelBilgisi", 1).apply()
                        sharedPreferences.edit().putInt("scoreBilgisi", 0).apply()
                        sharedPreferences.edit().putInt("currentPosition", 1).apply()
                        level = 1
                        score = 0
                        mCurrentPosition = 1
                        startActivity(intent)
                        finish()
                    }
                } else if (mSelectedOptionPosition == -2) {
                    mCurrentPosition++
                    if (mCurrentPosition <= mQuestionsList!!.size) setQuestion()
                    else if(mCurrentPosition == mQuestionsList!!.size + 1){
                        val intent = Intent(this,FinishActivity::class.java)
                        sharedPreferences.edit().putInt("levelBilgisi", 1).apply()
                        sharedPreferences.edit().putInt("scoreBilgisi", 0).apply()
                        sharedPreferences.edit().putInt("currentPosition", 1).apply()
                        level = 1
                        score = 0
                        mCurrentPosition = 1
                        startActivity(intent)
                        finish()
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answersView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        score -= 5
                    }else{
                        score += 20
                    }

                    answersView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        submitBtn.text = "FINISH"
                    } else {
                        submitBtn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = -2
                }
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun answersView(answer: Int, drawableView: Int){

        when(answer){
            1 -> opt1.background = ContextCompat.getDrawable(this, drawableView)
            2 -> opt2.background = ContextCompat.getDrawable(this, drawableView)
            3 -> opt3.background = ContextCompat.getDrawable(this, drawableView)
            4 -> opt4.background = ContextCompat.getDrawable(this, drawableView)

        }
    }
}