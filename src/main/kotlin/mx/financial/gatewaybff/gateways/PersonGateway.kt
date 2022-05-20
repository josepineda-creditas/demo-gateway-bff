package mx.financial.gatewaybff.gateways

import mx.financial.gatewaybff.models.person.Person
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PersonGateway {

    @GET("/v1/persons/{personId}")
    suspend fun findById(
        @Path("personId") personId: String,
        @Header("Accept") accept: String = "application/json"
    ): Person
}