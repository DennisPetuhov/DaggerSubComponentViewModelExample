package com.example.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MyViewModelFactory @Inject constructor(var repo: MyRepository, var dog: Dog) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            (modelClass.isAssignableFrom(ViewModelFirst::class.java!!)) -> {
                ViewModelFirst(repo) as T
            }
            (modelClass.isAssignableFrom(ViewModelSecond::class.java!!)) -> {
                ViewModelSecond(dog) as T
            }


            else -> {
                throw IllegalArgumentException("ViwModel not Found")
            }
        }
    }
}