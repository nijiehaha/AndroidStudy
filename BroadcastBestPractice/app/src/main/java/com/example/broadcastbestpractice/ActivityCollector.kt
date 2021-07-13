package com.example.broadcastbestpractice

import android.app.Activity

object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun add(activity: Activity) {
        activities.add(activity)
    }

    fun remove(activity: Activity) {
        activities.remove(activity)
    }
    fun finishAll() {
        for (act in activities) {
            if (!act.isFinishing) {
                act.finish()
            }
        }
        activities.clear()
    }


}