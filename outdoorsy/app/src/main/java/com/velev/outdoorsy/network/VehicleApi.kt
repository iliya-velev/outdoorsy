package com.velev.outdoorsy.network

import com.velev.outdoorsy.data.Vehicle

/**
 * @author Iliya Velev
 * @since 1.0
 */
interface VehicleApi {
    fun getVehicles(keyWords:String, callback: GetVehiclesCallback)

    interface GetVehiclesCallback {
        fun onSuccess(result: List<Vehicle>)

        fun onError(error: Throwable)
    }
}