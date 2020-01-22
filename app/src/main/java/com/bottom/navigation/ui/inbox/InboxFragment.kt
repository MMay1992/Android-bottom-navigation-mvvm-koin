package com.bottom.navigation.ui.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bottom.navigation.R
import com.bottom.navigation.databinding.InboxFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class InboxFragment : Fragment() {

    private lateinit var mBinding: InboxFragmentBinding
    private val viewModel: InboxViewModel by viewModel()

    companion object {
        fun newInstance() = InboxFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.inbox_fragment, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
