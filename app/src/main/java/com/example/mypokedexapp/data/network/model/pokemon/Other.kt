package com.example.mypokedexapp.data.network.model.pokemon
import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: com.example.mypokedexapp.data.network.model.pokemon.DreamWorld,
    val home: com.example.mypokedexapp.data.network.model.pokemon.Home,
    @SerializedName("official-artwork") val officialArtwork: com.example.mypokedexapp.data.network.model.pokemon.OfficialArtwork,
    val showdown: com.example.mypokedexapp.data.network.model.pokemon.Showdown
)