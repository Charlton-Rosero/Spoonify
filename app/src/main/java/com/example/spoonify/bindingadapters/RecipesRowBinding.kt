package com.example.spoonify.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.example.spoonify.R

class RecipesRowBinding {
    companion object{

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
    }
}