package com.elsistemas.controller;

import com.elsistemas.dto.CustomerDto;
import com.elsistemas.service.CustomerService;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> findAllCustomers() {
        return customerService.findAll();
    }

    @POST
    @Transactional()
    public Response save(CustomerDto dto) {
        try {
            customerService.createNewCustomer(dto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional()
    public Response update(@PathParam("id") Long id, CustomerDto dto) {
        try {
            customerService.changeCustomers(id, dto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional()
    public Response delete(@PathParam("id") Long id) {
        try {
            customerService.deleteCustomer(id);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto findById(@PathParam("id") Long id) {
        return customerService.findById(id);
    }

}
