package com.example.weather.presenters

import java.lang.StringBuilder

interface UserView {

    fun showResult()
    fun onStarted()
    fun displayGivenInTextView(city: String, temperature: String)
    fun displayListOfCities(str: StringBuilder)
}