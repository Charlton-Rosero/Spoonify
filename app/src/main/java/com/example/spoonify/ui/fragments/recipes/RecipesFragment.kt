package com.example.spoonify.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.spoonify.MainViewModel
import com.example.spoonify.R
import com.example.spoonify.adapters.RecipesAdapter
import com.example.spoonify.databinding.FragmentRecipesBinding
import com.example.spoonify.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private val mAdapter by lazy { RecipesAdapter() }
    private lateinit var recipesView: View
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipesView = inflater.inflate(R.layout.fragment_recipes, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return recipesView

//        setupRecyclerView()

    }
//    private fun requestApiData() {
//        mainViewModel.getRecipes(applyQueries())
//        mainViewModel.recipesResponse.observe(viewLifecycleOwner,{ response ->
//            when(response){
//                is NetworkResult.Success -> {
//                    hideShimmerEffect()
//                    response.data?.let { mAdapter.setData(it) }
//                }
//                is NetworkResult.Error -> {
//                    hideShimmerEffect()
//                    Toast.makeText(
//                        requireContext(),
//                        response.message.toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                is NetworkResult.Loading ->{
//                    showShimmerEffect()
//                }
//            }
//        })
//    }
//
//    private fun applyQueries(): Map<String, String> {
//        val queries: HashMap<String, String> = HashMap()
//
//        queries["number"]="50"
//        queries["apiKey"]="b4d820841ab045029449379781b3d1a5"
//        queries["type"]="snack"
//        queries["diet"]="vegan"
//        queries["addRecipeInformation"]="true"
//        queries["fillIngredients"]="true"
//
//        return queries
//    }
//
//    private fun setupRecyclerView() {
//        recipesView.recyclerview.adapter = mAdapter
//        recipesView.recyclerview.layoutManager = LinearLayoutManager(requireContext())
//        showShimmerEffect()
//    }
//
//    private fun showShimmerEffect() {
//        recipesView.recyclerview.showShimmer()
//    }
//
//    private fun hideShimmerEffect() {
//        recipesView.recyclerview.hideShimmer()
//    }

}