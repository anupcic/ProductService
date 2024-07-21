package com.anup.productserviceitsevening.dtos;

import com.anup.productserviceitsevening.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
