package com.example.dagger

import android.app.Application

class App : Application(){
    lateinit var myComponent: MyComponent // создаем объект интерфейса  май компонент
    //далее

    override fun onCreate() {


        super.onCreate()
        var myClass:MyClass = MyClass()

        myComponent = DaggerMyComponent.builder() //фактически  myComponent в апп стартрует даггер !!
            .context(this)
            .myclass(myClass)
            .build() //реализовали интрефейс майкомпонент
    }
}