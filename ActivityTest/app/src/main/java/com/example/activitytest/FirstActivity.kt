package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : BaseActivity() {

    companion object {
        private const val TAG = "FirstActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d(TAG, "onCreate: ${this.toString()}")
        Log.d(TAG, "onCreate: Task id is $taskId")
        val binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
//            Toast.makeText(this, "you clicked Button 1", Toast.LENGTH_SHORT) .show()
//            finish()
            /// 显式 intent
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            /// 隐式 intent
//            val intent = Intent("com.example.activity.ACTION_START")
//            intent.addCategory("com.example.activity.MY_CATEGORY")
//            startActivity(intent)
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)
//            val data = "Hello SecondActivity"
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", data)
//            startActivity(intent)
//            startActivityForResult(intent, 1)

//            val intent = Intent(this, FirstActivity::class.java)
//            startActivity(intent)

//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)

            SecondActivity.actionStart(this, "data1", "data2")

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "you clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "you clicked Remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }

}