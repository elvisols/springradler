package com.springapp.springradler.service.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @NotNull
    @ApiModelProperty(value = "Product item id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @ApiModelProperty(value = "Product item title")
    private String title;

}
