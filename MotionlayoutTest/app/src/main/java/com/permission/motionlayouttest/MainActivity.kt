package com.permission.motionlayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.permission.motionlayouttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {

            val constrainSet = binding.motionLayout.getConstraintSet(R.id.end)


        }
    }
}