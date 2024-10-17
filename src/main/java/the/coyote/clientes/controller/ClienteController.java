package the.coyote.clientes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import the.coyote.clientes.exception.DuplicateValue;
import the.coyote.clientes.model.dto.cliente.CadastroClienteDTO;
import the.coyote.clientes.model.dto.cliente.ListaBasicaClientesDTO;
import the.coyote.clientes.model.dto.cliente.ResponseCadastroClienteDTO;
import the.coyote.clientes.service.ClienteService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	@GetMapping("/")
	@Operation(summary = "Teste de serviço.", description = "Testando serviço de clientes com uma chamada http.")
	public String getMethodName() throws InternalServerError {
		try {
			return new String("Teste de controller de clientes executado com sucesso!");
		} catch (InternalServerError e) {
			return e.getStatusText();
		}
	}
	
	@GetMapping("/todos")
	@Operation(summary = "Lista todos os clientes.", description = "Retorna uma lista básica de todos os clientes.")
	public ResponseEntity<List<ListaBasicaClientesDTO>> listarTodosClientes(
			@RequestParam(required = false) Integer pagina, 
			@RequestParam(required = false) Integer quantidade)  {
		
		return ResponseEntity.ok().body(clienteService.listarTodosClientes(pagina, quantidade));
	}
	

	@PostMapping("/")
	@Operation(summary = "Cadastro de clientes", description = "Salva um novo cadastro de clientes no banco de dados.") 
	public ResponseEntity<ResponseCadastroClienteDTO> salvarCliente(@RequestBody CadastroClienteDTO cadastroClienteDTO) throws DuplicateValue {
		return ResponseEntity.ok().body(clienteService.salvarCliente(cadastroClienteDTO));
	}



}
