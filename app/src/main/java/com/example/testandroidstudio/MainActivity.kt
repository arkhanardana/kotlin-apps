package com.example.testandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pastikan ID button sesuai dengan yang ada di activity_main.xml
        val buttonGoToNext: ImageView = findViewById(R.id.buttonGoToNext)
        buttonGoToNext.setOnClickListener {
            // Pastikan SecondActivity terdaftar di AndroidManifest.xml
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        // Intent ke halaman Scan QR
        val buttonScanQR: ImageView = findViewById(R.id.buttonScanQR)
        buttonScanQR.setOnClickListener {
            val intent = Intent(this, ScanQRActivity::class.java)
            startActivity(intent)
        }
        val buttonPeta: ImageView = findViewById(R.id.buttonPeta)
        buttonPeta.setOnClickListener {
            val intent = Intent(this, PetaActivity::class.java)
            startActivity(intent)
        }
        val buttonAdiwiyata: ImageView = findViewById(R.id.buttonAdiwiyata)
        buttonAdiwiyata.setOnClickListener {
            val intent = Intent(this, AdiwiyataActivity::class.java)
            startActivity(intent)
        }
    }
}
