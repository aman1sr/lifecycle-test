package com.aman.lifecycletest.utils

import android.content.Context
import androidx.fragment.app.Fragment
/*
* difference: https://chatgpt.com/share/60e26938-9db8-4ce1-bced-2a5a080621da
* */
object Utils {
    fun addFragmentToParentFrg(parentFragment: Fragment, destinationFrg: Fragment, containerId: Int) {
        parentFragment.parentFragmentManager.beginTransaction()
            .add(containerId, destinationFrg)
            .addToBackStack(null)  // Optional: Add to back stack
            .commit()

    }

    fun replaceFragmentToParentFrg(childFragment: Fragment, fragment: Fragment, containerId: Int) {
        childFragment.parentFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)  // Optional: Add to back stack
            .commit()
    }

}