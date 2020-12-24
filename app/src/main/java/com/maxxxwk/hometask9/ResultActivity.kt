package com.maxxxwk.hometask9

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    companion object {
        private const val RESULT_KEY = "RESULT_KEY"
        fun start(result: Int, context: Context) {
            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra(RESULT_KEY, result)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result = intent.getIntExtra(RESULT_KEY, 0)
        supportFragmentManager.beginTransaction()
                .replace(R.id.root, ResultFragment.newInstance(result))
                .commit()
    }
}