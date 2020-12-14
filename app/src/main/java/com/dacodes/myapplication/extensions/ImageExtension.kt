package com.dacodes.myapplication.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.setImageCircularFrom(url: String, placeholder: Int?) {
    if (placeholder!= null) {
        Glide.with(context)
            .load(url)
            .circleCrop()
            .placeholder(placeholder)
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .circleCrop()
            .into(this)
    }
}