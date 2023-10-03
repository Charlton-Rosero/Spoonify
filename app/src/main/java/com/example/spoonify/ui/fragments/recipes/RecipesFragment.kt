package com.example.spoonify.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.spoonify.viewmodel.MainViewModel
import com.example.spoonify.R
import com.example.spoonify.adapters.RecipesAdapter
import com.example.spoonify.util.NetworkResult
import com.example.spoonify.viewmodel.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private val mAdapter by lazy { RecipesAdapter() }
    private lateinit var recipesView: View
    private lateinit var recipesViewModel: RecipesViewModel
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        recipesView = inflater.inflate(R.layout.fragment_recipes, container, false)
        setupRecyclerView()
        requestApiData()
        return recipesView
    }


    private fun requestApiData() {
        mainViewModel.getRecipes(recipesViewModel.applyQueries())
        mainViewModel.recipesResponse.observe(viewLifecycleOwner, { response ->
            when(response){
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading ->{
                    showShimmerEffect()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        recipesView.recyclerview.adapter = mAdapter
        recipesView.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect() {
        recipesView.recyclerview.showShimmer()
    }

    private fun hideShimmerEffect() {
        recipesView.recyclerview.hideShimmer()
    }

}