package com.example.weather.presenters

interface UserView {

    fun showResult()
    fun onStarted()
    fun displayGivenInTextView(city: String, temperature: Double)
}