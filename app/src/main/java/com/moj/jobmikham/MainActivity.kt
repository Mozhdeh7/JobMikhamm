package com.moj.jobmikham

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moj.jobmikham.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var jsonString = "https://jobs.github.com/positions.json?description=api"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}