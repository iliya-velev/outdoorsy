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
class VehicleRepositoryImpl private constructor(
    private val localSource: VehicleLocalSource,
    private val remoteSource: VehicleRemoteSource
) : VehicleRepository {

    companion object {
        private var INSTANCE: VehicleRepositoryImpl? = null
        fun getInstance(
            localSource: VehicleLocalSource,
            remoteSource: VehicleRemoteSource
        ): VehicleRepositoryImpl {
            if (INSTANCE == null) {
                INSTANCE = VehicleRepositoryImpl(localSource, remoteSource)
            }
            return INSTANCE!!
        }
    }

    override fun observeVehicles(): LiveData<ResultData<List<Vehicle>>> {
        return  localSource.observeVehicles()
    }

    override fun loadVehicles(kyeWords: String?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}