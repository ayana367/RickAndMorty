package com.example.rickandmorty.data.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.data.extenssion.loadImage
import com.example.rickandmorty.data.model.Characters
import com.example.rickandmorty.data.model.ResultsItem
import com.example.rickandmorty.databinding.ItemProfileBinding


class AdapterProfiles(private val characters: Characters): RecyclerView.Adapter<AdapterProfiles.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemProfileBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun onBind(resultsItem: ResultsItem) {
            binding.gender.text = resultsItem.gender
            binding.specie.text = resultsItem.species
            binding.name.text = resultsItem.name
            binding.image.loadImage(resultsItem.image)
            binding.statys.text = resultsItem.status
            binding.orgin.text = resultsItem.origin.toString()
            binding.type.text = resultsItem.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return characters.results!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(characters.results!![position])
    }
}

