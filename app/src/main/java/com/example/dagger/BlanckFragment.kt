package com.example.dagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import javax.inject.Inject

class BlanckFragment:Fragment() {
    lateinit var mySubComponent: LionSubComponent
    @Inject
    lateinit var lion:Lion
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mySubComponent =(requireActivity() as ActivityFirst).myComponent.lionComponent().build()

        mySubComponent.injectFragment(this)

        super.onViewCreated(view, savedInstanceState)
    }
}