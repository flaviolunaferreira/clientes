package the.coyote.clientes.model.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "clientes")
@EqualsAndHashCode(callSuper=false)
public class ClientesEntity extends BasicEntity {
	
	private String nome;

	private LocalDate dataNascimento;
	
    private List<DocumentoEntity> documentos; // Lista de documentos associados ao cliente

	public ClientesEntity(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
}