package com.kanandev.feature_auth.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.kanandev.feature_auth.databinding.FragmentIntroDemoBinding

/**
 * A simple [Fragment] subclass.
 * Use the [IntroDemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IntroDemoFragment : Fragment() {

    private var _binding: FragmentIntroDemoBinding? = null
    private val binding get() = _binding!!

    private lateinit var introAdapter: IntroAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        introAdapter = IntroAdapter(this)
        viewPager = binding.viewPager
        viewPager.adapter = introAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}