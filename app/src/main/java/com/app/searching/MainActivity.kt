package com.app.searching

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.searching.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callListeners()

    }

    private fun callListeners() {
        binding.etSearch.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (b) {
                binding.tvCancel.visibility = View.VISIBLE
            } else {
                binding.tvCancel.visibility = View.GONE
                binding.etSearch.let {
                    Log.d(TAG, "callListeners: 33")
                    KeyboardUtility.hideKeyboard(it)
                }
            }
        }

        binding.tvCancel.setOnClickListener {
            binding.etSearch.text = null
            binding.etSearch.clearFocus()
        }
    }
}