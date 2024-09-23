package com.example.testandroidstudio

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.views.MapView
import org.osmdroid.util.GeoPoint

class PetaActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memuat konfigurasi osmdroid
        Configuration.getInstance().load(this, android.preference.PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_peta)
        supportActionBar?.title = "Peta"

        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)

        // Inisialisasi MapView
        mapView = findViewById(R.id.mapView)
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
        mapView.setMultiTouchControls(true)

        // Mengatur posisi awal peta
        val startPoint = GeoPoint(-6.200000, 106.816666) // Contoh: Jakarta
        mapView.controller.setZoom(10.0)
        mapView.controller.setCenter(startPoint)

        buttonGoBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume() // Panggil onResume() untuk mapView
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause() // Panggil onPause() untuk mapView
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDetach() // Lepaskan sumber daya peta
    }
}
