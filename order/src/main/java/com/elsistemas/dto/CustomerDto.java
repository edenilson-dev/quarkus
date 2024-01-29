package com.elsistemas.dto;

import com.elsistemas.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

    public static CustomerDto to(Customer c) {
        return CustomerDto.builder()
                .id(c.getId())
                .name(c.getName())
                .email(c.getEmail())
                .phone(c.getPhone())
                .address(c.getAddress())
                .age(c.getAge())
                .build();
    }

    public static Customer to(CustomerDto d) {
        return Customer.builder()
                .name(d.getName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .age(d.getAge())
                .address(d.getAddress())
                .build();
    }

}
