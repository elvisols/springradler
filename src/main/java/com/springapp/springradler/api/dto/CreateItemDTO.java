package com.springapp.springradler.api.dto;

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
public class CreateItemDTO {

    @NotNull
    @Size(min = 1, max = 255)
    @ApiModelProperty(value = "Product item title")
    private String title;

}