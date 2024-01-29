package com.elsistemas.dto;

import com.elsistemas.entity.Pedido;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class PedidoDto {

    private Long id;

    private Long customerId;
    private String customerName;
    private Long productId;
    private BigDecimal orderValue;

    public static Pedido mapDTOToEntity(PedidoDto dto) {
        return Pedido.builder()
                .customerName(dto.getCustomerName())
                .customerId(dto.getCustomerId())
                .productId(dto.getProductId())
                .orderValue(dto.getOrderValue())
                .build();
    }

    public static PedidoDto mapEntityToDTO(Pedido item) {
        return PedidoDto.builder()
                .id(item.getId())
                .customerId(item.getCustomerId())
                .customerName(item.getCustomerName())
                .productId(item.getProductId())
                .orderValue(item.getOrderValue())
                .build();
    }
}
