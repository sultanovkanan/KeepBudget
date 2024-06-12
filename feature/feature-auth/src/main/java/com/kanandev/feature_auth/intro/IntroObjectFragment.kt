package com.kanandev.feature_auth.intro

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.kanandev.core_common.utils.Constants
import com.kanandev.feature_auth.R
import com.kanandev.feature_auth.databinding.FragmentIntroObjectBinding

/**
 * A simple [Fragment] subclass.
 * Use the [IntroObjectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class IntroObjectFragment : Fragment() {

    private var _binding: FragmentIntroObjectBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroObjectBinding.inflate(inflater, container, false)
        viewPager = (parentFragment as IntroDemoFragment).getViewPager()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(Constants.ARG_OBJECT) }?.getInt(Constants.ARG_OBJECT)?.let { position ->
            val viewSetupParams = when (position) {
                1 -> ViewSetupParams(R.drawable.illustration, R.string.intro_first_screen_title, R.string.intro_first_screen_desc, R.string.continue_btn)
                2 -> ViewSetupParams(R.drawable.moneygoes, R.string.intro_second_screen_title, R.string.intro_second_screen_desc, R.string.continue_btn)
                3 -> ViewSetupParams(R.drawable.moneyplan, R.string.intro_third_screen_title, R.string.intro_third_screen_desc, R.string.done_btn)
                else -> null
            }
            viewSetupParams?.let { parameters ->
                setupView(parameters.imageRes, getString(parameters.titleRes), getString(parameters.descRes), getString(parameters.buttonTextRes))
            }
        }
    }

    private fun setupView(imageRes: Int, title: String, desc: String, buttonText: String) {
        binding.apply {
            imageView.setImageResource(imageRes)
            textViewTitle.text = title
            textViewDesc.text = desc
            button.text = buttonText

            button.setOnClickListener {
                val currentItem = viewPager.currentItem
                val itemCount = viewPager.adapter?.itemCount ?: 0

                if (currentItem < itemCount - 1) {
                    viewPager.currentItem = currentItem + 1
                } else {
                    // Handle the case where it's the last screen
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

