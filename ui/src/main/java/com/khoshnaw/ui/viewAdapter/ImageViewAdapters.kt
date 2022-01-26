package com.khoshnaw.ui.viewAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:imageURL")
fun setImageURL(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}
