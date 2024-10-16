package the.coyote.clientes.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import the.coyote.clientes.model.entity.ClientesEntity;

public interface ClientesRepository extends MongoRepository<ClientesEntity, String> {

	List<ClientesEntity> findByNomeContainingIgnoreCase(String nome);

}
