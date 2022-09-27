package eber.loreto.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)

        //trueButton.setOnclickListener { view: view ->
        binding.trueButton.setOnClickListener { view: view ->
            //Toast.makeText(
                //this,R.string.correct_toast, Toast.LENGTH_SHORT
           // ).show()
            checkAnswer (true)
        }

        //falseButton.setOnclickListener { view: view ->
        binding.falseButton.setOnClickListener { view: View ->
            //Toast.makeText(
              //  this,R.string.incorrect_toast, Toast.LENGTH_LONG
            //).show()
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank(currentIndex).textResid
            //binding.questionTextView.setText(questionTextResId)
            updateQuestion()

        }
        //val questionTexResid = questionBank(currentIndex).textResId
        //binding.questionTextView.setText(questionTexResid)
        updateQuestion()
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onFause() called")
    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
            .show()
    }
}