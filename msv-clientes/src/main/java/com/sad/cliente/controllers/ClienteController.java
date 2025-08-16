package com.sad.cliente.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sad.cliente.services.ClienteService;
import com.sad.commons.controllers.CommonController;
import com.sad.commons.dtos.ClienteRequest;
import com.sad.commons.dtos.ClienteResponse;

@RestController
public class ClienteController extends CommonController<ClienteRequest, ClienteResponse, ClienteService>{

	public ClienteController(ClienteService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
}
