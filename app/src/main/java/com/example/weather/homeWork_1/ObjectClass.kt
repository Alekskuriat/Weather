package com.example.weather.homeWork_1

object ObjectClass {
    val cyties = ArrayList<Data>()
    val data = Data("Sochi", 32.4)


    init {

        cyties.add(data.copy(city = "Barnaul"))
        cyties.add(data.copy(city = "Omsk", temperature = 22.3))
        cyties.add(data.copy(city = "Tomsk", temperature = 15.3))
    }
}