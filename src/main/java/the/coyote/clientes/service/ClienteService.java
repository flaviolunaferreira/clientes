package the.coyote.clientes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import the.coyote.clientes.model.dto.CadastroClienteDTO;
import the.coyote.clientes.model.dto.ListaBasicaClientesDTO;
import the.coyote.clientes.model.dto.ResponseCadastroClienteDTO;

@Service
public interface ClienteService {

	List<ListaBasicaClientesDTO>  listarTodosClientes(Integer pagina, Integer quantidade);

	ResponseCadastroClienteDTO salvarCliente(CadastroClienteDTO cadastroClienteDTO);

}
