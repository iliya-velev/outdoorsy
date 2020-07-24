package com.velev.outdoorsy.di

import com.velev.outdoorsy.datasource.local.VehicleLocalSourceImpl
import com.velev.outdoorsy.datasource.remote.VehicleRemoteSourceImpl
import com.velev.outdoorsy.network.VehicleApiImpl
import com.velev.outdoorsy.repository.VehicleRepository
import com.velev.outdoorsy.repository.VehicleRepositoryImpl

/**
 * @author Iliya Velev
 * @since 1.0
 */
object Injection {

    fun getVehicleRepository(): VehicleRepository {
        return VehicleRepositoryImpl.getInstance(
            VehicleLocalSourceImpl(),
            VehicleRemoteSourceImpl(VehicleApiImpl())
        )
    }
}