package com.velev.outdoorsy.datasource.remote

import com.velev.outdoorsy.data.Vehicle
import com.velev.outdoorsy.network.VehicleApi

/**
 * @author Iliya Velev
 * @since 1.0
 */
interface VehicleRemoteSource {
    fun getVehicles(keyWords: String, callback: VehicleApi.GetVehiclesCallback)
}