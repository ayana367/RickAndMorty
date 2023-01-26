package com.example.rickandmorty.data.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.data.data.RemoteRepository
import com.example.rickandmorty.data.model.Characters
import com.example.rickandmorty.databinding.FragmentListBinding

@Suppress("UseExpressionBody")
class ListFragment : Fragment() {

    private var page =1
    private val repository = RemoteRepository()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(LayoutInflater.from(context), container, false)
        binding.swip.setOnRefreshListener {
            Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.profileFragment)
            binding.swip.isRefreshing = false
        }
        getCharacters()
        return binding.root
    }
    private fun getCharacters() {
        repository.getCharacters(page,this::onSuccess,this::onFailure)
    }

    private fun onSuccess(character: Characters){
        binding.recycclerview.adapter = CharacterAdapter(character,this::onCLick)
    }

    private fun onFailure(message:String){
        Log.i("ololo", "onFailure:$message")
    }

    private fun onCLick(pos:Int){
        Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
       findNavController().navigate(R.id.profileFragment)
    }
}

