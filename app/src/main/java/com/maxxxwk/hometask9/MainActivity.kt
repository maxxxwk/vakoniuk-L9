package com.maxxxwk.hometask9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val resultReceiver = AddResultReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupOnclickListener()
    }

    private fun setupOnclickListener() {
        findViewById<Button>(R.id.startAddServiceButton).setOnClickListener {
            AddService.start(12, 14, this)
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(resultReceiver, AddResultReceiver.getIntentFilter())
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(resultReceiver)
    }
}