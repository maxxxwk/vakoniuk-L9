package com.maxxxwk.hometask9

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService


class AddService : JobIntentService() {
    companion object {
        private const val FIRST_NUMBER_KEY = "FIRST_NUMBER_KEY"
        private const val SECOND_NUMBER_KEY = "SECOND_NUMBER_KEY"
        private const val JOB_ID = 217321
        fun start(firstNumber: Int, secondNumber: Int, context: Context) {
            val intent = Intent(context, AddService::class.java)
            intent.putExtra(FIRST_NUMBER_KEY, firstNumber)
            intent.putExtra(SECOND_NUMBER_KEY, secondNumber)
            enqueueWork(context, AddService::class.java, JOB_ID, intent)
        }
    }

    override fun onHandleWork(intent: Intent) {
        val firstNumber = intent.getIntExtra(FIRST_NUMBER_KEY, 0)
        val secondNumber = intent.getIntExtra(SECOND_NUMBER_KEY, 0)
        val result = firstNumber + secondNumber
        AddResultReceiver.sendResultToReceiver(result, this)
    }
}