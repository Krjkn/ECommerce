package com.ecommerce.producto.mapper;

import com.ecommerce.producto.entities.Productos;
import com.sad.commons.dtos.ProductoRequest;
import com.sad.commons.dtos.ProductoResponse;
import com.sad.commons.mappers.CommonMapper;

public abstract class ProductoMapper extends CommonMapper<ProductoRequest,ProductoResponse, Productos> {

}
