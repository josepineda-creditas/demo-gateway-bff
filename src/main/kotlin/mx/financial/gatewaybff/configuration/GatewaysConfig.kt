package mx.financial.gatewaybff.configuration

import mx.financial.gatewaybff.gateways.PersonGateway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit

@Configuration
class GatewaysConfig {

    @Bean
    fun personGateway(retrofit: Retrofit) = retrofit.create(PersonGateway::class.java)
}
