package the.coyote.clientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.clientes.exception.DuplicateValue;
import the.coyote.clientes.model.dto.cliente.CadastroClienteDTO;
import the.coyote.clientes.model.dto.cliente.ListaBasicaClientesDTO;
import the.coyote.clientes.model.dto.cliente.ResponseCadastroClienteDTO;

@Service
public interface ClienteService {

	List<ListaBasicaClientesDTO>  listarTodosClientes(Integer pagina, Integer quantidade);

	ResponseCadastroClienteDTO salvarCliente(CadastroClienteDTO cadastroClienteDTO) throws DuplicateValue;

}
