package com.example.startupinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.startupinfo.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the startup details from the intent
        val startupName = intent.getStringExtra("startup_name")
        val foundedYear = intent.getIntExtra("startup_foundedYear", 0)
        val sector = intent.getStringExtra("startup_sector")
        val description = intent.getStringExtra("startup_description")

        // Set the data to the views
        binding.tvStartupName.text = startupName
        binding.tvFoundedYear.text = "Kuruluş Yılı: $foundedYear"
        binding.tvSector.text = "Sektör: $sector"
        binding.tvDescription.text = description
    }
}
