package com.kanandev.feature_transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kanandev.feature_home.R
import com.kanandev.feature_home.databinding.FragmentTransactionBinding
import com.kanandev.feature_home.databinding.FragmentTransactionDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TransactionDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransactionDetailFragment : Fragment() {

    private var _binding: FragmentTransactionDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}