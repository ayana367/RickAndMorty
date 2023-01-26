package com.example.rickandmorty.data.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.data.data.RemoteRepository
import com.example.rickandmorty.data.model.Characters
import com.example.rickandmorty.databinding.FragmentProfileBinding


@Suppress("DEPRECATION")class ProfileFragment : Fragment() {

    private val repository = RemoteRepository()
    private var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        getCharacters()
        return binding.root
    }

    private fun getCharacters() {
        repository.getCharacters(page, this::onSuccess, this::onFailure)
    }

    private fun onSuccess(characters: Characters) {
        binding.recycclerview.adapter = AdapterProfiles(characters)
    }

    private fun onFailure(message: String) {
        Log.i("ololo", "onFailure:$message")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.back,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("CommitTransaction")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.back -> {
                Toast.makeText(requireContext(), "Toast", Toast.LENGTH_SHORT).show()
               findNavController().navigate(R.id.listFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
