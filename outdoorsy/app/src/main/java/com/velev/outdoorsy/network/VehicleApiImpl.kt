package com.velev.outdoorsy.network

import com.velev.outdoorsy.data.ResponseData
import com.velev.outdoorsy.data.Vehicle
import com.velev.outdoorsy.network.retrofit.RetrofitClient
import com.velev.outdoorsy.network.retrofit.VehicleApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Iliya Velev
 * @since 1.0
 */
class VehicleApiImpl : VehicleApi {

    private val api = RetrofitClient.instance.create(VehicleApiRetrofit::class.java)

    override fun getVehicles(keyWords: String, callback: VehicleApi.GetVehiclesCallback) {
        val retrofitCallback: Callback<ResponseData> = object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val dataList = data?.data ?: ArrayList<ResponseData.Data>()
                    val vehicles = ArrayList<Vehicle>()

                    if (data != null) {
                        for (entity in dataList) {
                            val name = entity.attributes?.name ?: ""
                            var imageUrl = ""

                            val imageId = entity.relationships?.primaryImage?.data?.id
                            if (!imageId.isNullOrEmpty()) {
                                val includedDataList = data.included ?: ArrayList()
                                for (included in includedDataList) {
                                    // TODO create and Enum with types
                                    if (included.type == "images" && included.id == imageId) {
                                        imageUrl = included.attribute?.url ?: ""
                                        break
                                    }
                                }
                            }

                            vehicles.add(Vehicle(name, imageUrl))
                        }
                    }

                    if (vehicles.isNotEmpty()) {
                        callback.onSuccess(vehicles)
                    } else {
                        callback.onError(Throwable("no data"))
                    }
                } else {
                    callback.onError(Throwable("response not succeeded http code:${response.code()}"))
                }
            }
        }

        val params = HashMap<String, String>()
        params.put("filters", keyWords)
        api.getVehicles(params).enqueue(retrofitCallback)
    }
}