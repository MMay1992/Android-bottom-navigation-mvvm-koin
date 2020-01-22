package com.watch.clip.android.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.watch.clip.android.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class WalletFragment : Fragment() {

    companion object {
        fun newInstance() = WalletFragment()
    }

    private val viewModel: WalletViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wallet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
