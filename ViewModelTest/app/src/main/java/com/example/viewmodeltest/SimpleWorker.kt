package com.example.viewmodeltest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(context: Context, params: WorkerParameters) :
 Worker(context, params) {

    companion object {
        private const val TAG = "SimpleWorker"
    }

    override fun doWork(): Result {
        Log.d(TAG, "doWork: 999999")
        return Result.success()
    }

}