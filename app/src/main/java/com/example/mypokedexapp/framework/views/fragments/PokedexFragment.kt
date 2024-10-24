package com.example.kotlin.mypokedexapp.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.framework.viewmodel.PokedexViewModel
import com.example.mypokedexapp.R
import com.example.mypokedexapp.data.network.model.PokemonBase
import com.example.mypokedexapp.databinding.FragmentPokedexBinding
import com.example.mypokedexapp.framework.adapters.PokemonAdapter

class PokedexFragment: Fragment() {
    private var _binding: FragmentPokedexBinding? = null

    private lateinit var viewModel: PokedexViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<PokemonBase>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        val root: View = _binding!!.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getPokemonList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root:View){
        recyclerView = root.findViewById(R.id.RVPokemon)
    }

    private fun initializeObservers() {
        viewModel.pokedexObjectLiveData.observe(viewLifecycleOwner) { poxedexObject ->
            setUpRecyclerView(poxedexObject.result)
        }
    }

    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        recyclerView.setHasFixedSize(true)
        /*val linearLayoutManager = LinearLayoutManager(
            requireContext(),        LinearLayoutManager.VERTICAL,        false)*/
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false)
        recyclerView.layoutManager = gridLayoutManager
        adapter.PokemonAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }
}