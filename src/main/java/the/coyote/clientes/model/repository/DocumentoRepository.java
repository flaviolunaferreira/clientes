package the.coyote.clientes.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import the.coyote.clientes.model.entity.ClientesEntity;
import the.coyote.clientes.model.entity.DocumentoEntity;

import java.util.Optional;

@Repository
public interface DocumentoRepository extends MongoRepository<DocumentoEntity, String> {
  
    // Método para encontrar um documento pelo tipo e número

    Optional<DocumentoEntity> findByTipoDocumentoAndNumero(String tipoDocumento, String numero);
    
    // Método para encontrar o cliente pelo tipo de documento e número
    Optional<ClientesEntity> findClienteByTipoDocumentoAndNumero(String tipoDocumento, String numero);

    Optional<DocumentoEntity> findByTipoDocumentoAndDadosDocumentoContains(String tipoDocumento, String numeroDocumento);

}
