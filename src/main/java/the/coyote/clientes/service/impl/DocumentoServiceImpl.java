package the.coyote.clientes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.repository.DocumentoRepository;
import the.coyote.clientes.service.DocumentoService;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public DocumentoEntity salvarDocumento(DocumentoEntity documento) {
        verificarDocumentoExistente(documento);
        return documentoRepository.save(documento);
    }

    @Override
    public DocumentoEntity atualizarDocumento(String id, DocumentoEntity documento) {
        DocumentoEntity documentoExistente = buscarDocumentoPorId(id);
        verificarDocumentoExistente(documento);
        documentoExistente.setTipoDocumento(documento.getTipoDocumento());
        documentoExistente.setDadosDocumento(documento.getDadosDocumento());
        return documentoRepository.save(documentoExistente);
    }

    @Override
    public void excluirDocumento(String id) {
        documentoRepository.deleteById(id);
    }

    @Override
    public DocumentoEntity buscarDocumentoPorId(String id) {
        return documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado."));
    }

    @Override
    public List<DocumentoEntity> listarDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public void verificarDocumentoExistente(DocumentoEntity documento) {
        String tipo = documento.getTipoDocumento().name();
        String numeroDocumento = documento.getDadosDocumento().get("Número");

        Optional<DocumentoEntity> documentoExistente = documentoRepository
            .findByTipoDocumentoAndDadosDocumentoContains(tipo, numeroDocumento);

        if (documentoExistente.isPresent()) {
            throw new RuntimeException("Este tipo de documento já está cadastrado para este cliente.");
        }

        // Verificação assíncrona em segundo plano
        verificarDuplicidadeEmClientes(documento);
    }

    @Async
    @Override
    public void verificarDuplicidadeEmClientes(DocumentoEntity documento) {
        // Simulação de pesquisa em outros cadastros de clientes
        // Aqui, você incluiria a lógica de busca em toda a base de clientes
        // e verificaria se o mesmo tipo de documento e número existem em outros registros.
        // Caso existam, você emitiria uma mensagem de alerta para o front-end.
    }
}
