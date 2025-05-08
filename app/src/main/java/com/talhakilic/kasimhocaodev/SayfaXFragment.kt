package com.talhakilic.kasimhocaodev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.talhakilic.kasimhocaodev.databinding.FragmentSayfaBBinding
import com.talhakilic.kasimhocaodev.databinding.FragmentSayfaXBinding


class SayfaXFragment : Fragment() {
    private var _binding : FragmentSayfaXBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSayfaXBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonYY.setOnClickListener{
            val action = SayfaXFragmentDirections.actionSayfaXFragmentToSayfaYFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}