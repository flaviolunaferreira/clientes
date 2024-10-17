package the.coyote.clientes.model.dto.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.ClientesEntity;
import the.coyote.clientes.model.entity.DocumentoEntity;

@Data
@NoArgsConstructor
public class ResponseCadastroClienteDTO {

	private String id;
	private String nome;
	private LocalDate dataNascimento;
	private List<DocumentoEntity> documentos;
	private String createdBy;
	private LocalDateTime dataDoCadastro;
	private LocalDateTime dataUltimaAlteracao;
	
	public ResponseCadastroClienteDTO(ClientesEntity cliente) {
		this.setId(cliente.getId());
		this.setNome(cliente.getNome());
		this.setDataNascimento(cliente.getDataNascimento());
		this.setDocumentos(cliente.getDocumentos());
		this.setCreatedBy(cliente.getCreatedBy());
		this.setDataDoCadastro(cliente.getCreatedDate());
		this.setDataUltimaAlteracao(cliente.getLastModifieldDate());
	}
	
}
