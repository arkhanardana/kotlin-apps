package com.example.testandroidstudio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var tvDisplay: TextView
    private var currentInput = ""
    private var operator = ""
    private var firstValue = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonGoToNext: Button = findViewById(R.id.button3)
        buttonGoToNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        tvDisplay = findViewById(R.id.tvDisplay)

        // Set onClickListeners for number buttons
        setNumberButtonListeners()

        // Set onClickListeners for operator buttons
        setOperatorButtonListeners()

        // Set onClickListener for the equals button
        val btnEquals: Button = findViewById(R.id.btnEquals)
        btnEquals.setOnClickListener {
            calculateResult()
        }

        // Set onClickListener for the clear button
        val btnClear: Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener {
            clearCalculator()
        }

        // Set onClickListener for the delete button
        val btnDelete: Button = findViewById(R.id.btnDelete)
        btnDelete.setOnClickListener {
            deleteLastCharacter()
        }

        // Set onClickListener for the custom button (button3)
//        val button3: Button = findViewById(R.id.button3)
//        button3.setOnClickListener {
//            customButtonAction()
//        }
    }

    private fun setNumberButtonListeners() {
        val numberButtonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnDecimal
        )

        val numberButtonClickListener = View.OnClickListener { view ->
            val button = view as Button
            currentInput += button.text.toString()
            tvDisplay.text = currentInput
            Log.d("Calculator", "Current Input: $currentInput")  // Tambahkan log
        }

        numberButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener(numberButtonClickListener)
        }
    }

    private fun setOperatorButtonListeners() {
        val operatorButtonIds = listOf(
            R.id.btnAdd, R.id.btnSubtract,
            R.id.btnMultiply, R.id.btnDivide
        )

        val operatorButtonClickListener = View.OnClickListener { view ->
            if (currentInput.isNotEmpty()) {
                firstValue = currentInput.toDouble()
                currentInput = ""
            }
            val button = view as Button
            operator = button.text.toString()
            Log.d("Calculator", "Operator: $operator")  // Tambahkan log
        }

        operatorButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener(operatorButtonClickListener)
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && operator.isNotEmpty()) {
            val secondValue = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstValue + secondValue
                "-" -> firstValue - secondValue
                "×" -> firstValue * secondValue
                "÷" -> if (secondValue != 0.0) firstValue / secondValue else {
                    tvDisplay.text = "Error"
                    return
                }
                else -> 0.0
            }

            tvDisplay.text = result.toString()
            currentInput = result.toString()
            operator = ""
        }
    }

    private fun clearCalculator() {
        currentInput = ""
        operator = ""
        firstValue = 0.0
        tvDisplay.text = "0"
    }

    private fun deleteLastCharacter() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            tvDisplay.text = if (currentInput.isEmpty()) "0" else currentInput
        }
    }

//    private fun customButtonAction() {
//
//        tvDisplay.text = "Custom Button Pressed"
//    }
}

