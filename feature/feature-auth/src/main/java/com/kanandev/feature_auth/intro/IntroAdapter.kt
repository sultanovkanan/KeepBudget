package com.kanandev.feature_auth.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kanandev.core_common.utils.Constants


class IntroAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = IntroObjectFragment()
        fragment.arguments = Bundle().apply {
            putInt(Constants.ARG_OBJECT, position + 1)
        }
        return fragment
    }

}