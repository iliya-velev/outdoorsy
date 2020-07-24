package com.velev.outdoorsy.datasource.local

import androidx.lifecycle.LiveData
import com.velev.outdoorsy.data.ResultData
import com.velev.outdoorsy.data.Vehicle

/**
 * @author Iliya Velev
 * @since 1.0
 */
interface VehicleLocalSource {

    fun observeVehicles() : LiveData<ResultData<List<Vehicle>>>

    fun updateData(data: List<Vehicle>)
}