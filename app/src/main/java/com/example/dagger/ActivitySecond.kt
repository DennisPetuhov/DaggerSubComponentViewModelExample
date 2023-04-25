package com.example.dagger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ActivitySecond:AppCompatActivity() {

    init {
        Log.e("%%%", "Viewmodel Second created")
    }
    lateinit var myComponent: MyComponent
    lateinit var vm:ViewModelSecond
    @Inject
    lateinit var myViewModelFactory: MyViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {

        myComponent = (applicationContext as App).myComponent
        myComponent.injectSecondActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        vm =ViewModelProvider(this, myViewModelFactory).get(ViewModelSecond::class.java)
    println(Dog(this))
    }


}