package com.r0930514.fastfoodorderapp.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

data class API(
    @SerializedName("MRData")
    val mrData: MRData
)
data class MRData(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("DriverTable")
    val driverTable: DriverTable
)
data class DriverTable(
    @SerializedName("Drivers")
    val drivers: List<Driver>
)
data class Driver(
    val driverId: String,
    val permanentNumber:String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String,
)


class DriverRepository{

    private val api = RetrofitInstance.f1ApiService
    var driverFlow : Flow<List<Driver>> = flow{
        try {
            val response = api.getDriverByYear(2021)
            if (response.isSuccessful){
                emit(response.body()!!.mrData.driverTable.drivers)
            }
        }catch (e: Exception){

        }
    }.flowOn(Dispatchers.IO)

}

class DriverViewModel() : ViewModel() {
    private val repository = DriverRepository()
    val drivers = repository.driverFlow
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}



