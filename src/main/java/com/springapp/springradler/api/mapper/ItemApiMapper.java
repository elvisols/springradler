package com.springapp.springradler.api.mapper;

import com.springapp.springradler.api.dto.CreateItemDTO;
import com.springapp.springradler.api.dto.UpdateItemDTO;
import com.springapp.springradler.service.domain.CreateItemRequest;
import com.springapp.springradler.service.domain.UpdateItemRequest;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemApiMapper {

    CreateItemRequest map(CreateItemDTO createItemDto);

    UpdateItemRequest map(UpdateItemDTO updateItemDto);

}