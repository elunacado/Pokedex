package com.example.mypokedexapp.data.network.model.pokemon

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: com.example.mypokedexapp.data.network.model.pokemon.StatX
)