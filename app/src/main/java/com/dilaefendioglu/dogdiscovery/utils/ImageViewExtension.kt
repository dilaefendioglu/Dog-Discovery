package com.dilaefendioglu.dogdiscovery.utils

import android.widget.ImageView
import com.dilaefendioglu.dogdiscovery.R
import com.squareup.picasso.Picasso

fun ImageView.setImageUrl(url: String?) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.load)
        .error(R.drawable.load)
        .into(this)
}