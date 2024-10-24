package com.example.mypokedexapp.data.network.model.pokemon

data class Move(
    val move: com.example.mypokedexapp.data.network.model.pokemon.MoveX,
    val version_group_details: List<com.example.mypokedexapp.data.network.model.pokemon.VersionGroupDetail>
)