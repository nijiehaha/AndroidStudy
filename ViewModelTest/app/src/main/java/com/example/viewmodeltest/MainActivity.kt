package com.example.viewmodeltest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import kotlinx.android.synthetic.main.activity_main.*

class Add<T:String>() {

    var t: T? = null

    init {

    }

}

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels<MainViewModel> {
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        MainViewModelFactory(countReserved)
    }
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProviders.of(this, MainViewModelFactory(countReserved))
//            .get(MainViewModel::class.java)

        plusOneButton.setOnClickListener {
//            viewModel.counter++
            viewModel.plusOne()
//            refreshCounter()
        }

        println("")

        clearButton.setOnClickListener {
            viewModel.clear()
//            viewModel.counter = 0
//            refreshCounter()
        }

//        refreshCounter()

        lifecycle.addObserver(MyObserver())

        viewModel.counter.observe(this) {
            infoText.text = it.toString()
        }

        getUserButton.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.getUser(userId)
        }

        viewModel.user.observe(this) {
            infoText.text = it.firstName
        }

        doWorkButton.setOnClickListener {
            val request = OneTimeWorkRequest
                .Builder(SimpleWorker::class.java)
                .build()
            WorkManager.getInstance(this)
                .enqueue(request)

        }

    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }

//    fun refreshCounter() {
//        infoText.text = viewModel.counter.toString()
//    }

}