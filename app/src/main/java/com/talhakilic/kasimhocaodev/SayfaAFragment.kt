package com.talhakilic.kasimhocaodev

import android.app.DirectAction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.talhakilic.kasimhocaodev.databinding.FragmentSayfaABinding

class SayfaAFragment : Fragment() {
    private var _binding : FragmentSayfaABinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSayfaABinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonB.setOnClickListener(){
            val action = SayfaAFragmentDirections.actionSayfaAFragmentToSayfaBFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}