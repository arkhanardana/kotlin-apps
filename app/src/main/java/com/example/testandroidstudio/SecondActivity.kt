package com.example.testandroidstudio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var resultTextView: TextView
    private var result: Double = 0.0
    private var currentOperation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Inisialisasi elemen UI di sini
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        resultTextView = findViewById(R.id.textResult)

        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonGoBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        buttonAdd.setOnClickListener {
            performOperation("+")
        }

        buttonSubtract.setOnClickListener {
            performOperation("-")
        }

        buttonDivide.setOnClickListener {
            performOperation("/")
        }

        buttonMultiply.setOnClickListener {
            performOperation("*")
        }

        buttonReset.setOnClickListener {
            result = 0.0
            currentOperation = null
            updateResult()

            number1.text.clear()
            number2.text.clear()
        }
    }

    private fun performOperation(operation: String) {
        val value1 = number1.text.toString().toDoubleOrNull()
        val value2 = number2.text.toString().toDoubleOrNull()

        if (value1 != null && value2 != null) {
            result = when (operation) {
                "+" -> value1 + value2
                "-" -> value1 - value2
                "*" -> value1 * value2
                "/" -> {
                    if (value2 != 0.0) {
                        value1 / value2
                    } else {
                        resultTextView.text = "Tidak bisa dibagi dengan 0"
                        return
                    }
                }

                else -> result // Default case if operation is not recognized
            }
            updateResult()
        } else {
            resultTextView.text = "Masukkan angka yang valid"
        }
    }


    private fun updateResult() {
        // Format the result to remove trailing .0 if it's a whole number
        val formattedResult = if (result % 1.0 == 0.0) {
            result.toInt().toString()
        } else {
            result.toString()
        }
        resultTextView.text = formattedResult
    }
}