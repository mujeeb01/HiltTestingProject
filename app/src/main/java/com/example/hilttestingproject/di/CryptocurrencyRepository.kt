package com.example.hilttestingproject.di

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}