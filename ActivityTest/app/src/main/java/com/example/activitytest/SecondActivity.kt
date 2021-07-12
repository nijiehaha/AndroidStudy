package com.example.activitytest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.ActivitySecondBinding
import com.example.activitytest.databinding.FirstLayoutBinding

class SecondActivity : BaseActivity() {

    companion object {
        private const val TAG = "SecondActivity"

        fun actionStart(context: Context, data1: String, data2:String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("Param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Task id is $taskId")
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra_data is $extraData")
        binding.button2.setOnClickListener {
//            intent.putExtra("data_return", "Hello FirstActivity")
//            setResult(RESULT_OK, intent)
//            finish()
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

    }
}