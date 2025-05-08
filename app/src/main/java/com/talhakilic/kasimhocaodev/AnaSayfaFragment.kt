package com.talhakilic.kasimhocaodev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.talhakilic.kasimhocaodev.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {
    private var _binding : FragmentAnaSayfaBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentAnaSayfaBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonA.setOnClickListener{
            val action = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToSayfaAFragment()
            Navigation.findNavController(it).navigate(action)
        }

        binding.buttonX.setOnClickListener{
            val action = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToSayfaXFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}