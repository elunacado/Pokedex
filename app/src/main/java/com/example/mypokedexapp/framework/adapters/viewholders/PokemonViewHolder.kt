package com.example.mypokedexapp.framework.adapters.viewholders

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.mypokedexapp.domain.PokemonInfoRequirement
import com.example.kotlin.mypokedexapp.framework.views.activities.PokemonDetailActivity
import com.example.mypokedexapp.data.network.model.PokemonBase
import com.example.mypokedexapp.data.PokemonRepository
import com.example.mypokedexapp.data.network.model.pokemon.pokemon
import com.example.mypokedexapp.databinding.ItemPokemonBinding
import com.example.mypokedexapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

    private fun getPokemonInfo(url:String, imageView:ImageView,context:Context){
        //"https://pokeapi.co/api/v2/pokemon/23/"
        var pokemonStringNumber:String = url.replace("https://pokeapi.co/api/v2/pokemon/","")
        pokemonStringNumber = pokemonStringNumber.replace("/","")
        val pokemonNumber:Int = Integer.parseInt(pokemonStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val pokemonInfoRequirement = PokemonInfoRequirement()
            val result: pokemon? = pokemonInfoRequirement(pokemonNumber)

            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.sprites?.other?.officialArtwork?.front_default.toString()

                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }}
    fun bind(item: PokemonBase, context:Context){
        binding.TVName.text = item.name
        getPokemonInfo(item.url,binding.IVPhoto,context)

        binding.llPokemon.setOnClickListener {
            passViewGoToPokemonDetail(item.url,context)
        }
    }

    private fun passViewGoToPokemonDetail(url: String,context:Context){
        var intent: Intent = Intent(context, PokemonDetailActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        context.startActivity(intent)
        intent.putExtra(Constants.URL_POKEMON,url)
    }


}