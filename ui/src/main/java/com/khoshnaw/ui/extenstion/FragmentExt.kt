package com.khoshnaw.ui.extenstion

import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

@MainThread
inline fun <reified B : ViewBinding> Fragment.dataBindings(
    crossinline inflateMethod: (View) -> B
): Lazy<B> = lazy { inflateMethod(view!!) }
