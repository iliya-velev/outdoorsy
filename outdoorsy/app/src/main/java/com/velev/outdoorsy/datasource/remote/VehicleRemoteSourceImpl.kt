package com.velev.outdoorsy.datasource.remote

import com.velev.outdoorsy.network.VehicleApi

/**
 * @author Iliya Velev
 * @since 1.0
 */
class VehicleRemoteSourceImpl(private val api: VehicleApi) : VehicleRemoteSource {

    override fun getVehicles(keyWords: String, callback: VehicleApi.GetVehiclesCallback) {
        api.getVehicles(keyWords, callback)
    }
}