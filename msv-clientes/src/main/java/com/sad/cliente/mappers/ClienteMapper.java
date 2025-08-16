package com.sad.cliente.mappers;

import org.springframework.stereotype.Component;

import com.sad.cliente.entities.Cliente;
import com.sad.commons.dtos.ClienteRequest;
import com.sad.commons.dtos.ClienteResponse;
import com.sad.commons.mappers.CommonMapper;

@Component
public class ClienteMapper extends CommonMapper<ClienteRequest, ClienteResponse, Cliente>{

	@Override
	public ClienteResponse entityToResponse(Cliente entity) {
		if(entity == null) {
			return null;
		}
		ClienteResponse response = new ClienteResponse(
				entity.getIdCliente(),
				entity.getNombre(),
				entity.getApellido(),
				entity.getEmail(),
				entity.getTelefono(),
				entity.getDireccion()
				
				);

        return response;
	}

	@Override
	public Cliente requestToEntity(ClienteRequest request) {
		if(request == null) {
			return null;
		}
		Cliente cliente = new Cliente();
        cliente.setNombre(request.nombre());
        cliente.setApellido(request.apellido());
        cliente.setEmail(request.email());
        cliente.setTelefono(request.telefono());
        cliente.setDireccion(request.direccion());
        return cliente;
	}

	

}
