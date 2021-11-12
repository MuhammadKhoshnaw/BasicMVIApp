package com.khoshnaw.ui.extenstion

import android.app.Activity
import android.view.LayoutInflater
import androidx.annotation.MainThread
import androidx.viewbinding.ViewBinding

@MainThread
inline fun <reified B : ViewBinding> Activity.dataBindings(
    crossinline inflateMethod: (LayoutInflater) -> B
): Lazy<B> = lazy {
    inflateMethod(layoutInflater)
}
