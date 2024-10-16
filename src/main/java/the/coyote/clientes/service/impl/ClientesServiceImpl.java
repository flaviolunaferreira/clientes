package the.coyote.clientes.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import the.coyote.clientes.exception.DuplicateValue;
import the.coyote.clientes.model.dto.CadastroClienteDTO;
import the.coyote.clientes.model.dto.ListaBasicaClientesDTO;
import the.coyote.clientes.model.dto.ResponseCadastroClienteDTO;
import the.coyote.clientes.model.entity.ClientesEntity;
import the.coyote.clientes.model.repository.ClientesRepository;
import the.coyote.clientes.service.ClienteService;

@Service
@RequiredArgsConstructor
public class ClientesServiceImpl implements ClienteService{

	private final ClientesRepository clientesRepository;

	@Override
	public List<ListaBasicaClientesDTO> listarTodosClientes(Integer pagina, Integer quantidade) {

	      int paginaFinal = (pagina != null) ? pagina : 0;
	        int quantidadeFinal = (quantidade != null) ? quantidade : 50;

	    PageRequest pageable = PageRequest.of(paginaFinal, quantidadeFinal);
	    Page<ClientesEntity> lista = clientesRepository.findAll(pageable);
	    
	    return lista.stream().map(ListaBasicaClientesDTO::new).collect(Collectors.toList());
	
	}

	@Override
	public ResponseCadastroClienteDTO salvarCliente(CadastroClienteDTO cadastroClienteDTO) throws DuplicateValue {
		
		List<ClientesEntity> cliente = clientesRepository.findByNomeContainingIgnoreCase(cadastroClienteDTO.getNome());

		if (!cliente.isEmpty()) throw(new DuplicateValue("Sinto muito, já tenho um cliente com esse nome. -> " + cadastroClienteDTO.getNome()));

		return new ResponseCadastroClienteDTO(clientesRepository.save(cadastroClienteDTO.novoCliente()));
	}
	
}
