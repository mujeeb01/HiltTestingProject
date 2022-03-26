package com.example.hilttestingproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hilttestingproject.R
import com.example.hilttestingproject.di.CryptocurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // viewModels() delegate used to get
    // ViewModel in MainActivity class
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeCryptoCurrency()
    }

    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
            val cryptocurrencyList = findViewById<RecyclerView>(R.id.cryptocurrency_list)
            cryptocurrencyList.layoutManager = LinearLayoutManager(this)
            cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
        }
    }
}