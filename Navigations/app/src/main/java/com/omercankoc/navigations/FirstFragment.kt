package com.omercankoc.navigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class FirstFragment : Fragment() {

    private lateinit var buttonNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonNext = view.findViewById(R.id.buttonNext)
        buttonNext.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Send data with Navigation to Second Fragment!")
            Navigation.findNavController(it).navigate(action)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}