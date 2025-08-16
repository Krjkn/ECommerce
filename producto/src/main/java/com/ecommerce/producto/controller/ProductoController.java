package com.ecommerce.producto.controller;

import com.ecommerce.producto.services.ProductoService;
import com.sad.commons.controllers.CommonController;
import com.sad.commons.dtos.ProductoRequest;
import com.sad.commons.dtos.ProductoResponse;
import com.sad.commons.services.CommonService;

public class ProductoController extends CommonController<ProductoResponse, ProductoRequest, ProductoService> {

	public ProductoController(ProductoService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
