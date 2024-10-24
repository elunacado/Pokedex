package com.example.mypokedexapp.data.network.model.pokemon
import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire") val omegarubyAlphasapphire: com.example.mypokedexapp.data.network.model.pokemon.OmegarubyAlphasapphire,
    @SerializedName("x-y") val xY: com.example.mypokedexapp.data.network.model.pokemon.XY
)