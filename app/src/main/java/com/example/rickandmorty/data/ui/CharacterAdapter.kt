package com.example.rickandmorty.data.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.data.extenssion.loadImage
import com.example.rickandmorty.data.model.Characters
import com.example.rickandmorty.data.model.ResultsItem
import com.example.rickandmorty.databinding.ItemCharactersBinding


@Suppress("ImplicitThis")
class CharacterAdapter(private val characters: Characters, private var onClick:(Int)->Unit):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun onBind(resultsItem: ResultsItem) {
            binding.characterName.text = resultsItem.name
            binding.characterImage.loadImage(resultsItem.image)
            binding.click.setOnClickListener {
                onClick(resultsItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return characters.results!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(characters.results!![position])
    }
}