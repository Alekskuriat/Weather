package com.example.weather.presenters

import com.example.weather.homeWork_1.Data
import com.example.weather.homeWork_1.ObjectClass
import java.lang.StringBuilder


class UserPresenterImpl(private val userView: UserView) : UserPresenter {


    override fun onStart() {
        userView.onStarted()
    }

    override fun onStop() {

    }

    override fun onUserAction() {

        val data = Data("moscow", 23.5)
        val temperatureTmp = data.temperature.toString()
        userView.displayGivenInTextView(data.city, temperatureTmp.plus(" C"))
    }

    override fun displayAction() {
        var stringTmp = StringBuilder()
        stringTmp.append("Список городов\n\n")
        for (a in ObjectClass.cyties) {
            stringTmp.append(a.toString() + "\n")
        }
        userView.displayListOfCities(stringTmp)
    }


}