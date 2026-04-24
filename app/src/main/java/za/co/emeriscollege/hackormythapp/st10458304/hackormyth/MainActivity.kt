package za.co.emeriscollege.hackormythapp.st10458304.hackormyth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// Main entry activity of the app
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Link XML layout
        setContentView(R.layout.activity_main)

        // Get button reference
        val startButton = findViewById<Button>(R.id.startButton)

        // Navigate to Quiz screen
        startButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}