package the.coyote.clientes.model.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
@EqualsAndHashCode(callSuper=false)
public class ClientesEntity extends BasicEntity {
	
	private String nome;

	private LocalDate dataNascimento;
	
	public ClientesEntity(String nome) {
		this.nome = nome;
	}
	
}