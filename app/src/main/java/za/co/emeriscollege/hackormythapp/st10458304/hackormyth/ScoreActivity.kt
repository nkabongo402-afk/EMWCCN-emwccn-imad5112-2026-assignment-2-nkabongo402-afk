package za.co.emeriscollege.hackormythapp.st10458304.hackormyth

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

// Displays final score and feedback
class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val restartButton = findViewById<Button>(R.id.restartButton)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        // Performance message
        val message = when {
            score == total -> "🔥 Perfect!"
            score >= total / 2 -> "👍 Good job!"
            else -> "💀 Try again!"
        }

        scoreText.text = "Score: $score / $total\n$message"

        // Restart quiz
        restartButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}