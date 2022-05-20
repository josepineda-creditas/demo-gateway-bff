package mx.financial.gatewaybff.api

import mx.financial.gatewaybff.models.person.Person
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/persons")
interface PersonApi {

    @GetMapping("/{personId}")
    suspend fun findById(
        @PathVariable personId: String,
    ): Person
}