package com.example.mypokedexapp.data.network.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: com.example.mypokedexapp.data.network.model.pokemon.Emerald,
    @SerializedName("firered-leafgreen") val firered_leafgreen: com.example.mypokedexapp.data.network.model.pokemon.FireredLeafgreen,
    @SerializedName("ruby_sapphire") val ruby_sapphire: com.example.mypokedexapp.data.network.model.pokemon.RubySapphire
)