package com.velev.outdoorsy.repository

import androidx.lifecycle.LiveData
import com.velev.outdoorsy.data.ResultData
import com.velev.outdoorsy.data.Vehicle

/**
 * @author Iliya Velev
 * @since 1.0
 */
interface VehicleRepository {
    fun observeVehicles() : LiveData<ResultData<List<Vehicle>>>
    fun loadVehicles(kyeWords: String? = null)
}