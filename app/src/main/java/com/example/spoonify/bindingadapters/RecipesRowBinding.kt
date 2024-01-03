package com.example.spoonify.bindingadapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.example.spoonify.R
import com.example.spoonify.models.Result
import com.example.spoonify.ui.fragments.recipes.RecipesFragmentDirections
import org.jsoup.Jsoup

class RecipesRowBinding {
    companion object{

        @BindingAdapter("onRecipeClickListener")
        @JvmStatic
        fun onRecipeClickListener(recipeRowLayout: ConstraintLayout, result: Result) {
            Log.d("onRecipeClickListener", "CALLED")
            recipeRowLayout.setOnClickListener {
                try {
                    val action =
                        RecipesFragmentDirections.actionRecipesFragmentToDetailsActivity(result)
                    recipeRowLayout.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.d("onRecipeClickListener", e.toString())
                }
            }
        }


        @JvmStatic
        @BindingAdapter("numberOfLikes")
        fun setNumberOfLikes(textView: TextView, likes: Int){
            textView.text = likes.toString()

        }

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String){
            imageView.load(imageUrl){
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
            }
        }
        @JvmStatic
        @BindingAdapter("setPrepTime")
        fun setPrepTime(textView: TextView, minutes: Int){
            textView.text = minutes.toString()

        }

        @JvmStatic
        @BindingAdapter("isVegan")
        fun isVegan(view: View, vegan: Boolean){
            if(vegan){
                when(view){
                    is TextView ->{
                        view.setTextColor(
                            ContextCompat.getColor(
                                view.context,
                                R.color.green
                            )
                        )
                    }
                    is ImageView ->{
                        view.setColorFilter(
                            ContextCompat.getColor(
                                view.context,
                                R.color.green
                            )
                        )
                    }
                }
            }
        }
        @JvmStatic
        @BindingAdapter("parseHtml")
        fun parseHtml(textView: TextView, description:String?){
            if (description != null){
                val desc = Jsoup.parse(description).text()
                textView.text = desc
            }
        }
    }
}