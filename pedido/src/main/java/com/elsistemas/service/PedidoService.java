package com.elsistemas.service;

import com.elsistemas.client.CustomerClient;
import com.elsistemas.client.ProductClient;
import com.elsistemas.dto.CustomerDto;
import com.elsistemas.dto.PedidoDto;
import com.elsistemas.repository.PedidoRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PedidoService {

    @Inject
    private PedidoRepository pedidoRepository;

    @Inject
    @RestClient
    private CustomerClient customerClient;

    @Inject
    @RestClient
    private ProductClient productClient;


    public List<PedidoDto> getAllOrders(){

        List<PedidoDto> orders = new ArrayList<>();

        orders = pedidoRepository.findAll().stream().map(PedidoDto::mapEntityToDTO).collect(Collectors.toList());

        return orders;
    }


    public void saveNewOrder(PedidoDto orderDTO){

        CustomerDto customerDTO = customerClient.findById(orderDTO.getCustomerId());

        if(customerDTO.getName().equals(orderDTO.getCustomerName())
                && productClient.getProductById(orderDTO.getProductId()) != null){
            pedidoRepository.persist(PedidoDto.mapDTOToEntity(orderDTO));
        } else {
            throw new NotFoundException();
        }

    }

}
