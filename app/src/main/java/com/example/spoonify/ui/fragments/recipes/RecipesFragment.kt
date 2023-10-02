package com.example.spoonify.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spoonify.R
import com.example.spoonify.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {


    private lateinit var recipesView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        recipesView = inflater.inflate(R.layout.fragment_recipes, container, false)



        return recipesView
    }
    private fun showShimmerEffect() {
        recipesView.recyclerview.showShimmer()
    }

}