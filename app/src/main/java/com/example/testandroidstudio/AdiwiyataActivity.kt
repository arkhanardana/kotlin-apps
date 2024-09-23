package com.example.testandroidstudio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.net.Uri

class AdiwiyataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiwiyata)
        supportActionBar?.title = "Adiwiyata"

        val buttonOpenWebsite: Button = findViewById(R.id.buttonOpenWebsite)
        buttonOpenWebsite.setOnClickListener {
            // URL yang akan dibuka
            val url =
                "https://www.smk2-yk.sch.id/berita/adiwiyata-smk-n-2-yogyakarta-mendapat-bantuan-tree-planting-dari-pt-komatsu-indonesia"

            // Membuat intent untuk membuka URL
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            // Memulai activity
            startActivity(intent)
        }
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)


        buttonGoBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }
}