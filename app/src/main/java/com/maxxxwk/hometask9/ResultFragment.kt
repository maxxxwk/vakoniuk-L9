package com.maxxxwk.hometask9

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment(R.layout.fragment_result) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultTextView = view.findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = arguments?.getInt(RESULT_KEY).toString()
    }

    companion object {
        private const val RESULT_KEY = "RESULT_KEY"
        fun newInstance(result: Int): ResultFragment {
            val fragment = ResultFragment()
            val bundle = Bundle()
            bundle.putInt(RESULT_KEY, result)
            fragment.arguments = bundle
            return fragment
        }
    }
}