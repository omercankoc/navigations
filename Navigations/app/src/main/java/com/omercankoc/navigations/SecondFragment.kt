package com.omercankoc.navigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class SecondFragment : Fragment() {

    private lateinit var buttonBack : Button
    private lateinit var textViewSecond : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        textViewSecond = view.findViewById(R.id.textViewSecond)

        arguments?.let {
            val username = SecondFragmentArgs.fromBundle(it).username
            textViewSecond.text = username
        }

        buttonBack = view.findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            Navigation.findNavController(it).navigate(action)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}