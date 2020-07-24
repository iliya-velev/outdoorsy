package com.velev.outdoorsy.network.retrofit

import com.velev.outdoorsy.data.ResponseData
import com.velev.outdoorsy.data.Vehicle
import com.velev.outdoorsy.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author Iliya Velev
 * @since 1.0
 */
interface VehicleApiRetrofit {

    @GET(Constants.RENTALS)
    fun getVehicles(@QueryMap params: Map<String, String>): Call<ResponseData>
}