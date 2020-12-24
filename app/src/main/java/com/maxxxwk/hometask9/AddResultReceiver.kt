package com.maxxxwk.hometask9

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

class AddResultReceiver : BroadcastReceiver() {
    companion object {
        private const val SHOW_RESULT_ACTION = "com.maxxxwk.intent.action.SHOW_RESULT"
        private const val RESULT_KEY = "ADD_RESULT_KEY"
        fun getIntentFilter() = IntentFilter(SHOW_RESULT_ACTION)
        fun sendResultToReceiver(result: Int, context: Context) {
            val intent = Intent(SHOW_RESULT_ACTION)
            intent.putExtra(RESULT_KEY, result)
            context.sendBroadcast(intent)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let { intent ->
            val result = intent.getIntExtra(RESULT_KEY, 0)
            context?.let { context ->
                ResultActivity.start(result, context)
                Log.d("MY_DEBUG", "AddResultReceiver inside context let")
            }
        }
    }
}