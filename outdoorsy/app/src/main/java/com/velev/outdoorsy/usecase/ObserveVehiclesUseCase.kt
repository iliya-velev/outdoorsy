package com.velev.outdoorsy.usecase

import com.velev.outdoorsy.repository.VehicleRepository

/**
 * @author Iliya Velev
 * @since 1.0
 */
class ObserveVehiclesUseCase(private val vehicleRepository: VehicleRepository) {

    operator fun invoke() = vehicleRepository.observeVehicles()
}