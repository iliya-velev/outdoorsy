package com.velev.outdoorsy.repository

import androidx.lifecycle.LiveData
import com.velev.outdoorsy.data.ResultData
import com.velev.outdoorsy.data.Vehicle
import com.velev.outdoorsy.datasource.local.VehicleLocalSource
import com.velev.outdoorsy.datasource.remote.VehicleRemoteSource

/**
 * @author Iliya Velev
 * @since 1.0
 */
class VehicleRepositoryImpl(private val localSource: VehicleLocalSource,
                            private val remoteSource: VehicleRemoteSource) : VehicleRepository {

    override fun observeVehicles(): LiveData<ResultData<List<Vehicle>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadVehicles(kyeWords: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}