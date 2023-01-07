package com.example.diet.TooDiet

data class TooDietModel (
    //Food
    var Id: Int = 0,
    var Name: String = "",
    var Amount: String = "",
    var Calories: String = "",
    var Type: String = "",

    //Excerice
    var IdEx: Int = 0,
    var NameEx: String = "",
    var Hour: String = "",
    var CaloriesEx: String = "",


    var visibility: Boolean = false
)