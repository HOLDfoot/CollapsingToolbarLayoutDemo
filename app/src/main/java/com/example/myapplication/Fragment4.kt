package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFragment4Binding

class Fragment4 : Fragment() {

    private lateinit var binding: FragmentFragment4Binding

    private var mList: MutableList<String> = mutableListOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFragment4Binding.inflate(layoutInflater)
        initData()
        return binding.root
    }

    private fun initData() {
        for (i in 0..19) {
            mList.add("MaterialDesign$i")
        }
    }

}