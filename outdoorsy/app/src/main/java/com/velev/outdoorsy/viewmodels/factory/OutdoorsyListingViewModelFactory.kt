package com.velev.outdoorsy.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.velev.outdoorsy.di.Injection
import com.velev.outdoorsy.usecase.KeywordsComposerUseCase
import com.velev.outdoorsy.usecase.LoadVehiclesByKeywordsUseCase
import com.velev.outdoorsy.usecase.LoadVehiclesUseCase
import com.velev.outdoorsy.usecase.ObserveVehiclesUseCase
import com.velev.outdoorsy.viewmodels.OutdoorsyListingViewModel

/**
 * @author Iliya Velev
 * @since 1.0
 */
class OutdoorsyListingViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == OutdoorsyListingViewModel::class.java) {
            return OutdoorsyListingViewModel(
                KeywordsComposerUseCase(),
                LoadVehiclesByKeywordsUseCase(Injection.getVehicleRepository()),
                LoadVehiclesUseCase(Injection.getVehicleRepository()),
                ObserveVehiclesUseCase(Injection.getVehicleRepository())
            ) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}