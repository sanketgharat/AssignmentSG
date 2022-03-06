package com.sg.assignment.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sg.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonAssignment1.setOnClickListener {
            startActivity(Intent(this@MainActivity, AssignmentOneActivity::class.java))
        }
        binding.buttonAssignment2.setOnClickListener {
            startActivity(Intent(this@MainActivity, AssignmentTwoActivity::class.java))
        }

    }
}