package com.example.mypokedexapp.data.network.model.pokemon

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: com.example.mypokedexapp.data.network.model.pokemon.MoveLearnMethod,
    val version_group: com.example.mypokedexapp.data.network.model.pokemon.VersionGroup
)