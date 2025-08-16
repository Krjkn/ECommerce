package com.sad.cliente.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sad.cliente.entities.Cliente;
import com.sad.cliente.mappers.ClienteMapper;
import com.sad.cliente.repositories.ClienteRepository;
import com.sad.commons.dtos.ClienteRequest;
import com.sad.commons.dtos.ClienteResponse;

@Service
public class ClienteServiceImpl implements ClienteService{
	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;

	

	public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
	}

	@Override
    @Transactional(readOnly = true)
    public List<ClienteResponse> listar() {
		return clienteRepository.findAll().stream()
				.map(clienteMapper::entityToResponse).toList();
    }

	@Override
	@Transactional(readOnly = true)
	public ClienteResponse obtenrPorId(Long id) {
		return clienteMapper.entityToResponse(clienteRepository.findById(id).orElseThrow(null));
	}

	@Override
	@Transactional
	public ClienteResponse insertar(ClienteRequest request) {
		return clienteMapper.entityToResponse(clienteRepository.save(clienteMapper.requestToEntity(request)));
	}

	@Override
	@Transactional
	public ClienteResponse actualizar(ClienteRequest request, Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow();
		cliente.setNombre(request.nombre());
		cliente.setEmail(request.email());
		cliente.setTelefono(request.telefono());
		cliente.setDireccion(request.direccion());
		return clienteMapper.entityToResponse(clienteRepository.save(cliente));
	}

	@Override
	@Transactional
	public ClienteResponse eliminar(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow();
		clienteRepository.deleteById(id);
		return clienteMapper.entityToResponse(cliente);
	}

}
