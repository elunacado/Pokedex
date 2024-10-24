package com.example.mypokedexapp.data.network.model.pokemon
import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-i") val generationI: com.example.mypokedexapp.data.network.model.pokemon.GenerationI,
    @SerializedName("generation-ii") val generationII: com.example.mypokedexapp.data.network.model.pokemon.GenerationIi,
    @SerializedName("generation-iii") val generationIII: com.example.mypokedexapp.data.network.model.pokemon.GenerationIii,
    @SerializedName("generation-iv") val generationIV: com.example.mypokedexapp.data.network.model.pokemon.GenerationIv,
    @SerializedName("generation-v") val generationV: com.example.mypokedexapp.data.network.model.pokemon.GenerationV,
    @SerializedName("generation-vi") val generationVI: com.example.mypokedexapp.data.network.model.pokemon.GenerationVi,
    @SerializedName("generation-vii") val generationVII: com.example.mypokedexapp.data.network.model.pokemon.GenerationVii,
    @SerializedName("generation-viii") val generationVIII: com.example.mypokedexapp.data.network.model.pokemon.GenerationViii
)