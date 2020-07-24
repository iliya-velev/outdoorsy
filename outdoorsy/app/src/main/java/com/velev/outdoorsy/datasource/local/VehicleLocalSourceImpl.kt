package com.velev.outdoorsy.datasource.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.velev.outdoorsy.data.ResultData
import com.velev.outdoorsy.data.Vehicle

/**
 * @author Iliya Velev
 * @since 1.0
 */
class VehicleLocalSourceImpl : VehicleLocalSource {

    private val data = ArrayList<Vehicle>()

    private val vehicleState = MutableLiveData<ResultData<List<Vehicle>>>()
        .apply {
            value = ResultData.None
        }

    override fun observeVehicles() = vehicleState as LiveData<ResultData<List<Vehicle>>>

    override fun updateData(data: List<Vehicle>) {
        this.data.clear()
        this.data.addAll(data)
        vehicleState.postValue(ResultData.Success(this.data))
    }
}