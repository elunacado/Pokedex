package com.example.mypokedexapp.data.network.model

import com.google.gson.annotations.SerializedName

data class PokedexObject(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val result: ArrayList<com.example.mypokedexapp.data.network.model.PokemonBase>,
    )