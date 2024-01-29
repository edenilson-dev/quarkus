package com.elsistemas.dto;

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

}
