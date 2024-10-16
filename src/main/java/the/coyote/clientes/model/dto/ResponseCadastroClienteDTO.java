package the.coyote.clientes.model.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.ClientesEntity;

@Data
@NoArgsConstructor
public class ResponseCadastroClienteDTO {

	private String id;
	private String nome;
	private String createdBy;
	private LocalDateTime dataDoCadastro;
	private LocalDateTime dataUltimaAlteracao;
	
	public ResponseCadastroClienteDTO(ClientesEntity cliente) {
		this.setId(cliente.getId());
		this.setNome(cliente.getNome());
		this.setCreatedBy(cliente.getCreatedBy());
		this.setDataDoCadastro(cliente.getCreatedDate());
		this.setDataUltimaAlteracao(cliente.getLastModifieldDate());
	}
	
}
