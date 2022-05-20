package mx.financial.gatewaybff.controllers

import mx.financial.gatewaybff.api.PersonApi
import mx.financial.gatewaybff.models.person.Person
import org.springframework.web.bind.annotation.RestController
import mx.financial.gatewaybff.gateways.PersonGateway

@RestController
class PersonController(
    private val personGateway: PersonGateway
) : PersonApi {
    override suspend fun findById(personId: String): Person {
        var person= personGateway.findById(personId)
        println(person)
        return person
    }
}