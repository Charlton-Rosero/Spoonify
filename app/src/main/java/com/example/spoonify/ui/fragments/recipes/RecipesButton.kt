package com.example.spoonify.ui.fragments.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spoonify.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class RecipesButton : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.recipes_bottom_sheet, container, false)
    }

}