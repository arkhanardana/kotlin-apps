package com.example.testandroidstudio

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity) // Corrected layout name to avoid space issue
        supportActionBar?.hide()
        // Timer splash screen selama 5 detik (5000ms)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java) // Corrected intent syntax
            startActivity(intent)
            finish() // Menutup SplashActivity agar tidak bisa kembali ke splash screen
        }, 5000) // 5000ms = 5 detik
    }
}