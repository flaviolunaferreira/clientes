package the.coyote.clientes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import the.coyote.clientes.model.entity.ClientesEntity;

public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {

	List<ClientesEntity> findByNomeContainingIgnoreCase(String nome);

}
