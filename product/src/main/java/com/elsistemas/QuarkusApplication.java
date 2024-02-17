package com.elsistemas;

import io.quarkus.eureka.client.EurekaClient;
import io.quarkus.eureka.client.loadBalancer.LoadBalanced;
import io.quarkus.eureka.client.loadBalancer.LoadBalancerType;
import io.quarkus.runtime.Startup;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
@Startup
public class QuarkusApplication {

    @Inject
    @LoadBalanced(type = LoadBalancerType.ROUND_ROBIN)
    public EurekaClient eurekaClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return eurekaClient.app("product")
                .path("/actuator/health")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get()
                .readEntity(String.class);
    }
}
