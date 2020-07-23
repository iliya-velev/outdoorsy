package com.velev.outdoorsy.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.velev.outdoorsy.R

/**
 * @author Iliya Velev
 * @since 1.0
 */
object ActivityUtil {


    fun replaceFragmentInActivity(fragmentManager: FragmentManager,
                                  fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.commitAllowingStateLoss()
    }
}