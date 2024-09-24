package com.example.testandroidstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QRResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_result)

        val qrResultTextView: TextView = findViewById(R.id.qrResultTextView)
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)

        // Dapatkan hasil QR dari intent
        val qrResult = intent.getStringExtra("QR_RESULT")
        qrResultTextView.text = qrResult

        // Kembali ke activity sebelumnya
        buttonGoBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }
}
