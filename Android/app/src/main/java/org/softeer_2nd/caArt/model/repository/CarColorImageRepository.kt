package org.softeer_2nd.caArt.model.repository

import org.softeer_2nd.caArt.model.data.dto.ColorData
import org.softeer_2nd.caArt.model.network.ColorApiService
import javax.inject.Inject

class CarColorImageRepository @Inject constructor(private val service: ColorApiService) {

    suspend fun fetchColorList(trimId: Int): ColorData {
        return service.getColorList(trimId).data!!
    }
}