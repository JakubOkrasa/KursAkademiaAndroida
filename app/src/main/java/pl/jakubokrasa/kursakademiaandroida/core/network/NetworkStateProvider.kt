package pl.jakubokrasa.kursakademiaandroida.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}