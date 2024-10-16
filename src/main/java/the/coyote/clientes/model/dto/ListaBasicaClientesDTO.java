package the.coyote.clientes.model.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.ClientesEntity;

@Data
@NoArgsConstructor
public class ListaBasicaClientesDTO {
	
	private String id;
	private String nome;
	private LocalDateTime dataDoCadastro;
	
	public ListaBasicaClientesDTO(ClientesEntity cliente) {
		this.setId(cliente.getId());
		this.setNome(cliente.getNome());
		this.setDataDoCadastro(cliente.getCreatedDate());
	}

}
