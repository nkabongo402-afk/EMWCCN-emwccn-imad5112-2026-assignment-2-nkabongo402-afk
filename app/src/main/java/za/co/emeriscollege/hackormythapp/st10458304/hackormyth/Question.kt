package za.co.emeriscollege.hackormythapp.st10458304.hackormyth

// Data model representing a quiz question
data class Question(
    val text: String,          // Question text
    val isHack: Boolean,       // Correct answer
    val explanation: String    // Explanation for feedback
)