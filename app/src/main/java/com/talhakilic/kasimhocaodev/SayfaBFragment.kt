package com.talhakilic.kasimhocaodev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.talhakilic.kasimhocaodev.databinding.FragmentSayfaABinding
import com.talhakilic.kasimhocaodev.databinding.FragmentSayfaBBinding

class SayfaBFragment : Fragment() {
    private var _binding : FragmentSayfaBBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSayfaBBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonY.setOnClickListener{
            val action = SayfaBFragmentDirections.actionSayfaBFragmentToSayfaYFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}