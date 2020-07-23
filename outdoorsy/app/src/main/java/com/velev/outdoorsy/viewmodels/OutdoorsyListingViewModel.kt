package com.velev.outdoorsy.viewmodels

import androidx.lifecycle.ViewModel
import com.velev.outdoorsy.usecase.KeywordsComposerUseCase
import com.velev.outdoorsy.usecase.LoadVehiclesByKeywordsUseCase
import com.velev.outdoorsy.usecase.LoadVehiclesUseCase
import com.velev.outdoorsy.usecase.ObserveVehiclesUseCase

/**
 * @author Iliya Velev
 * @since 1.0
 */
class OutdoorsyListingViewModel(private val keywordsComposerUseCase: KeywordsComposerUseCase,
                                private val loadVehiclesByKeywordsUseCase: LoadVehiclesByKeywordsUseCase,
                                private val loadVehiclesUseCase: LoadVehiclesUseCase,
                                private val observeVehiclesUseCase: ObserveVehiclesUseCase) : ViewModel() {

    fun observeVehicles() = observeVehiclesUseCase()

    fun loadVehicles(keyWordsString: String? = null) {
        if (keyWordsString.isNullOrEmpty()) {
            loadVehiclesUseCase()
        } else {
            val keyWordsComposedString = keywordsComposerUseCase(keyWordsString)
            loadVehiclesByKeywordsUseCase(keyWordsComposedString)
        }
    }
}