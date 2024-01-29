package com.elsistemas.client;

import com.elsistemas.dto.ProductDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/v1/products")
@RegisterRestClient(configKey = "product-client")
@ApplicationScoped
public interface ProductClient {

    @GET
    @Path("/{id}")
    ProductDto getProductById(@PathParam("id") Long id);
}
