package the.coyote.clientes.service;

import the.coyote.clientes.model.entity.DocumentoEntity;
import java.util.List;

public interface DocumentoService {
    DocumentoEntity salvarDocumento(DocumentoEntity documento);
    DocumentoEntity atualizarDocumento(String id, DocumentoEntity documento);
    void excluirDocumento(String id);
    DocumentoEntity buscarDocumentoPorId(String id);
    List<DocumentoEntity> listarDocumentos();
    
    void verificarDocumentoExistente(DocumentoEntity documento);
    void verificarDuplicidadeEmClientes(DocumentoEntity documento);
}