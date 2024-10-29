package com.example.testandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonWisata: ImageView = findViewById(R.id.buttonWisata)
        buttonWisata.setOnClickListener {
            val intent = Intent(this, WisataActivity::class.java)
            startActivity(intent)
        }

        val buttonKuliner: ImageView = findViewById(R.id.buttonKuliner)
        buttonKuliner.setOnClickListener {
            val intent = Intent(this, KulinerActivity::class.java)
            startActivity(intent)
        }
    }
}
