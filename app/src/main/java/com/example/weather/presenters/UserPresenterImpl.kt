package com.example.weather.presenters

import com.example.weather.homeWork_1.Data

class UserPresenterImpl (private val userView: UserView) : UserPresenter{


    override fun onStart() {
        userView.onStarted()
    }

    override fun onStop() {

    }

    override fun onUserAction() {
        val data = Data("Moscow", 23.3);
        userView.displayGivenInTextView(data.city, data.temperature)

    }
}