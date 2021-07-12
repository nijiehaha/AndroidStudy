package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.ActivityThirdBinding

class ThirdActivity : BaseActivity() {
    
    companion object {
        private const val TAG = "ThirdActivity"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThirdBinding.inflate(layoutInflater)
        Log.d(TAG, "onCreate: Task id is $taskId")
        setContentView(binding.root)
        binding.button3.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }
}