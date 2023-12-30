package com.example.spoonify.ui.fragments.recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.example.spoonify.R
import com.example.spoonify.databinding.RecipesBottomSheetBinding
import com.example.spoonify.util.Constants.Companion.DEFAULT_DIET_TYPE
import com.example.spoonify.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.spoonify.viewmodels.RecipesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.Locale


class RecipesBottomSheet : BottomSheetDialogFragment() {

    private lateinit var recipesViewModel: RecipesViewModel

    private var _binding: RecipesBottomSheetBinding? = null
    private val binding get() = _binding!!

    private var mealTypeChip = DEFAULT_MEAL_TYPE
    private var mealTypeChipId = 0
    private  var dietTypeChip = DEFAULT_DIET_TYPE
    private var dietTypeChipId = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RecipesBottomSheetBinding.inflate(inflater, container, false)

        recipesViewModel.readMealAndDietType.asLiveData().observe(viewLifecycleOwner) { value ->
            mealTypeChip = value.selectedMealType
            dietTypeChip = value.selectedDietType
            updateChip(value.selectedMealTypeId, binding.chipGroupMealType)
            updateChip(value.selectedDietTypeId, binding.chipGroupDietType)
        }

        binding.chipGroupMealType.setOnCheckedStateChangeListener{ group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId.first())
            val selectedMealType = chip.text.toString().lowercase(Locale.ROOT)
            mealTypeChip = selectedMealType
            mealTypeChipId = checkedId.first()

        }

        binding.chipGroupDietType.setOnCheckedStateChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId.first())
            val selectedDietType = chip.text.toString().lowercase(Locale.ROOT)
            dietTypeChip = selectedDietType
            dietTypeChipId = checkedId.first()
        }

        binding.buttonApply.setOnClickListener{
            recipesViewModel.saveMealAndDietType(
                mealTypeChip,
                mealTypeChipId,
                dietTypeChip,
                dietTypeChipId
            )
            val action = RecipesBottomSheetDirections.actionRecipesBottomSheetToRecipesFragment()
            action.bottomSheet = true
            findNavController().navigate(action)

            Log.d("ArgumentCheck", action.bottomSheet.toString() )
        }


        return binding.root

    }

    private fun updateChip(chipId: Int, chipGroup: ChipGroup){
        if(chipId != 0){
            try {
                chipGroup.findViewById<Chip>(chipId).isChecked = true
            }catch (e: Exception){
                Log.d("RecipesBottomSheet", e.message.toString())
            }
        }
    }



    }