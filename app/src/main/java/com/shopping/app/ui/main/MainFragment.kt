package com.shopping.app.ui.main

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
import com.shopping.app.databinding.FragmentMainBinding
import com.shopping.app.ui.main.adapter.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment: Fragment() {

    private lateinit var mBinding: FragmentMainBinding
    private val model: MainViewModel by viewModel()
    private val mainAdapter = MainAdapter()

    companion object{

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        subscribeAccount()
    }

    private fun subscribeAccount() {
        model.data().observe(this, Observer { resource ->
            when{
                resource.status == Status.SUCCESS ->
                    mainAdapter.submitList(resource.data)
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
            this.adapter = mainAdapter
            this.isNestedScrollingEnabled = false
        }
    }
}