package the.coyote.clientes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import the.coyote.clientes.model.dto.CadastroClienteDTO;
import the.coyote.clientes.model.dto.ListaBasicaClientesDTO;
import the.coyote.clientes.model.dto.ResponseCadastroClienteDTO;
import the.coyote.clientes.service.ClienteService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	@GetMapping()
	@Operation(description = "Teste de funcionamento do controller.")
	public String getMethodName() {
		return new String("Teste de controller de clientes executado com sucesso!");
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<ListaBasicaClientesDTO>> listarTodosClientes(
			@RequestParam(required = false) Integer pagina, 
			@RequestParam(required = false) Integer quantidade)  {
		
		return ResponseEntity.ok().body(clienteService.listarTodosClientes(pagina, quantidade));
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseCadastroClienteDTO> salvarCliente(@RequestBody CadastroClienteDTO cadastroClienteDTO) {
		return ResponseEntity.ok().body(clienteService.salvarCliente(cadastroClienteDTO));
	}

}
