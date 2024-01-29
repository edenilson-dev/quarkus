package com.elsistemas.controller;

import com.elsistemas.dto.ProductDto;
import com.elsistemas.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Path("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @POST
    @Transactional
    public Response save(ProductDto dto) {
        try {
            productService.createNewProduct(dto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProductDto dto) {
        try {
            productService.changeProduct(id, dto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            productService.delete(id);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<ProductDto> findAllProducts() {
        return productService.getAllProduct();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDto findById(@PathParam("id") Long id) {
        return productService.findById(id);
    }

}
