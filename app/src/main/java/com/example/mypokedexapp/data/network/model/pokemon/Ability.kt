package com.example.mypokedexapp.data.network.model.pokemon

data class Ability(
    val ability: com.example.mypokedexapp.data.network.model.pokemon.AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)