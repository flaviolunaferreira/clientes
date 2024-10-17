package the.coyote.clientes.model.dto.cliente;

import java.time.LocalDate;

import lombok.Data;
import the.coyote.clientes.model.entity.ClientesEntity;

@Data
public class CadastroClienteDTO {

	private String nome;
	private LocalDate dataNascimento;

	public ClientesEntity novoCliente() {
		return new ClientesEntity(nome, dataNascimento);
	}
	
}
