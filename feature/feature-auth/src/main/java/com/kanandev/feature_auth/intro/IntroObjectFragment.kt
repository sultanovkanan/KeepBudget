package com.kanandev.feature_auth.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(Constants.ARG_OBJECT) }?.apply {
            when (getInt(Constants.ARG_OBJECT)) {
                1 -> setupView(
                    R.drawable.illustration,
                    getString(R.string.intro_first_screen_title),
                    getString(R.string.intro_first_screen_desc),
                    getString(R.string.done_btn)
                )

                2 -> setupView(
                    R.drawable.moneygoes,
                    getString(R.string.intro_second_screen_title),
                    getString(R.string.intro_second_screen_desc),
                    getString(R.string.done_btn)
                )

                3 -> setupView(
                    R.drawable.moneyplan,
                    getString(R.string.intro_third_screen_title),
                    getString(R.string.intro_third_screen_desc),
                    getString(R.string.done_btn)
                )
            }
        }
    }

    private fun setupView(imageRes: Int, title: String, desc: String, buttonText: String) {
        binding.apply {
            imageView.setImageResource(imageRes)
            textViewTitle.text = title
            textViewDesc.text = desc
            button.text = buttonText
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}