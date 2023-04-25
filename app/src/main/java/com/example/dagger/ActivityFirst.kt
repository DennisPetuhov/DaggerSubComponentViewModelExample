package com.example.dagger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ActivityFirst : AppCompatActivity() {

    //Activity -> Component -> Module ->
    @Inject
    lateinit var cat: Cat

    //Аннотациями @Inject мы помечаем поля, которые компонент должен заполнить (инджектить).
    @Inject
    lateinit var dog: Dog
    lateinit var myComponent: MyComponent

    lateinit var vm: ViewModelFirst
    @Inject
    lateinit var  myViewModelFactory: MyViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        myComponent =
            (applicationContext as App).myComponent // получаем ссылку в активити на майкомпонент
        // имеем доступ в любой активити к  контексту и любым зависимостям   через  приведение к Аpp
        // applicationContext и далее через точку май компонени фактически  myComponent в апп стартрует даггер !!
        //После этого MainActivity сможет получать от компонента все необходимые объекты.
        myComponent.injectFirstActivity(this) // после вывода метода инджект начинают рабоать зависимости
        // мы говорим компоненту, что когда мы будем вызывать этот метод и передавать туда
        // экземпляр MainActivity, мы ожидаем, что компонент наполнит этот экземпляр требуемыми объектами.


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // myViewModelFactory=MyViewModelFactory(MyRepository()) убрали после того как сделали диай
        vm = ViewModelProvider(this,myViewModelFactory).get(ViewModelFirst::class.java)
        println(cat)
        println(cat.myClass)
        println(dog)
        println(dog.context)
        val intent=Intent(this,ActivitySecond::class.java)
        startActivity(intent)
    }
}