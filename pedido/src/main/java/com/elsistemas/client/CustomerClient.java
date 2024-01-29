package com.elsistemas.client;

import com.elsistemas.dto.CustomerDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/v1/customers")
@RegisterRestClient(configKey = "customer-client")
@ApplicationScoped
public interface CustomerClient {

    @GET
    @Path("/{id}")
    CustomerDto findById(@PathParam("id") Long id);
}
