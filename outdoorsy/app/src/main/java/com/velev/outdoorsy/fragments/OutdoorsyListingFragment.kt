package com.velev.outdoorsy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.velev.outdoorsy.R
import com.velev.outdoorsy.data.ResultData
import com.velev.outdoorsy.viewmodels.OutdoorsyListingViewModel
import com.velev.outdoorsy.viewmodels.factory.OutdoorsyListingViewModelFactory

/**
 * @author Iliya Velev
 * @since 1.0
 */
class OutdoorsyListingFragment : Fragment() {

    companion object {
        fun newInstance() = OutdoorsyListingFragment()
    }

    private val viewModel: OutdoorsyListingViewModel by lazy {
        ViewModelProvider(this, OutdoorsyListingViewModelFactory()).get(OutdoorsyListingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_outdoorsy_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeVehicles().observe(viewLifecycleOwner, Observer {
            when(it) {
                is ResultData.Success -> {

                }
                is ResultData.Error -> {
                    Toast.makeText(context, it.exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        })

        viewModel.loadVehicles()
    }

}