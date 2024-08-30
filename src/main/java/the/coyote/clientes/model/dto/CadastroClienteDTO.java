package the.coyote.clientes.model.dto;

import lombok.Data;
import the.coyote.clientes.model.entity.ClientesEntity;

@Data
public class CadastroClienteDTO {

	private String nome;

	public ClientesEntity novoCliente() {
		return new ClientesEntity(nome);
	}
	
}
