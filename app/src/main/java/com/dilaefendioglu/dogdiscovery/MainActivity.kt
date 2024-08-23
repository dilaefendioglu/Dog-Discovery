package com.dilaefendioglu.dogdiscovery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dilaefendioglu.dogdiscovery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}