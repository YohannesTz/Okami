package com.yohannes.dev.app.okami.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yohannes.dev.app.okami.databinding.ActivityOpenBinding

class OpenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOpenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


    }
}