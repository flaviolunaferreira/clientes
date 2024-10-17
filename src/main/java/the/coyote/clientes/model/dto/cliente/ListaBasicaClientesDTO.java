package the.coyote.clientes.model.dto.cliente;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.ClientesEntity;
import the.coyote.clientes.model.entity.DocumentoEntity;

@Data
@NoArgsConstructor
public class ListaBasicaClientesDTO {
	
	private String id;
	private String nome;
	private List<DocumentoEntity> documentos;
	private LocalDateTime dataDoCadastro;
	
	public ListaBasicaClientesDTO(ClientesEntity cliente) {
		this.setId(cliente.getId());
		this.setNome(cliente.getNome());
		this.setDataDoCadastro(cliente.getCreatedDate());
		this.setDocumentos(cliente.getDocumentos());
	}

}
