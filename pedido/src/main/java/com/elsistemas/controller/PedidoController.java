package com.elsistemas.controller;

import com.elsistemas.dto.PedidoDto;
import com.elsistemas.service.PedidoService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/pedidos")
public class PedidoController {

    @Inject
    private PedidoService pedidoService;

    @GET
    @RolesAllowed({"user", "admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoDto> getAllPedidos() {
        return pedidoService.getAllOrders();
    }

    @POST
    @Transactional
    public Response saveNewPedido(PedidoDto dto) {
        try {
            pedidoService.saveNewOrder(dto);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
