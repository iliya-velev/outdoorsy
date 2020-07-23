package com.velev.outdoorsy.usecase

import com.velev.outdoorsy.repository.VehicleRepository

/**
 * @author Iliya Velev
 * @since 1.0
 */
class LoadVehiclesByKeywordsUseCase(private val vehicleRepository: VehicleRepository) {

    operator fun invoke(keyWords: String) = vehicleRepository.loadVehicles(keyWords)
}