package com.bottom.navigation.ui.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bottom.navigation.R
import com.bottom.navigation.databinding.MeFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MeFragment : Fragment() {

    private lateinit var mBinding: MeFragmentBinding
    private val viewModel: MeViewModel by viewModel()

    companion object {
        fun newInstance() = MeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.me_fragment, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
