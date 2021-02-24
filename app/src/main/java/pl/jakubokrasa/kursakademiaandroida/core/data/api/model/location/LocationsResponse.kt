package pl.jakubokrasa.kursakademiaandroida.core.data.api.model.location

import com.google.gson.annotations.SerializedName
import pl.jakubokrasa.kursakademiaandroida.core.data.api.model.ResponseInfo

data class LocationsResponse(
    @SerializedName("info")val info: ResponseInfo,
    @SerializedName("results")val results: List<LocationRemote>
){

}