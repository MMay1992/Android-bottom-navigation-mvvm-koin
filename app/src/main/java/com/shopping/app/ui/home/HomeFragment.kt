package com.shopping.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shopping.app.R
import com.shopping.app.api.model.Status
import com.shopping.app.databinding.HomeFragmentBinding
import com.shopping.app.ui.home.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var mBinding: HomeFragmentBinding
    private val viewModel: HomeViewModel by viewModel()
    private val homeAdapter = HomeAdapter()

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        subscribeAccount()
    }

    private fun subscribeAccount() {
        viewModel.data().observe(this, Observer { resource ->
            when{
                resource.status == Status.SUCCESS -> { }

                resource.status == Status.ERROR ->
                    Toast.makeText(
                        context,
                        "Error: ${resource.dataError?.message}",
                        Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView() {
        mBinding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = homeAdapter
            this.isNestedScrollingEnabled = false
        }
    }
}
