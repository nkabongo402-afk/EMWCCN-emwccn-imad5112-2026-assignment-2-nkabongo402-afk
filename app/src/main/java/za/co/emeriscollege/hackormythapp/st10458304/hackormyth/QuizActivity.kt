package za.co.emeriscollege.hackormythapp.st10458304.hackormyth

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

// Handles quiz logic and user interaction
class QuizActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var hackButton: Button
    private lateinit var mythButton: Button
    private lateinit var nextButton: Button
    private lateinit var imageView: ImageView

    private var currentIndex = 0
    private var score = 0

    // List of questions
    private val questions = arrayOf(
        Question("Putting your phone in rice fixes water damage.", false, "Rice does NOT fix internal damage."),
        Question("Airplane mode makes your phone charge faster.", true, "Less network = faster charging."),
        Question("Closing apps saves battery.", false, "It can actually drain more battery."),
        Question("Dark mode saves battery.", true, "True for OLED screens.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        hackButton = findViewById(R.id.hackButton)
        mythButton = findViewById(R.id.mythButton)
        nextButton = findViewById(R.id.nextButton)
        imageView = findViewById(R.id.imageView)

        loadQuestion()

        hackButton.setOnClickListener {
            animateButton(hackButton)
            checkAnswer(true)
        }

        mythButton.setOnClickListener {
            animateButton(mythButton)
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex++

            if (currentIndex < questions.size) {
                loadQuestion()
                resetButtons()
            } else {
                // Go to score screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    // Load current question
    private fun loadQuestion() {
        val q = questions[currentIndex]
        questionText.text = q.text

        // Change image based on answer type
        if (q.isHack) {
            imageView.setImageResource(R.drawable.hack)
        } else {
            imageView.setImageResource(R.drawable.myth)
        }
    }

    // Check user's answer
    private fun checkAnswer(userAnswer: Boolean) {
        val q = questions[currentIndex]

        hackButton.isEnabled = false
        mythButton.isEnabled = false

        if (userAnswer == q.isHack) {
            score++
            Toast.makeText(this, "Correct ✅\n${q.explanation}", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Wrong ❌\n${q.explanation}", Toast.LENGTH_LONG).show()
        }
    }

    // Reset buttons for next question
    private fun resetButtons() {
        hackButton.isEnabled = true
        mythButton.isEnabled = true
    }

    // Simple click animation
    private fun animateButton(button: Button) {
        button.scaleX = 0.9f
        button.scaleY = 0.9f
        button.animate().scaleX(1f).scaleY(1f).duration = 150
    }
}