package the.coyote.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.service.DocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<DocumentoEntity> criarDocumento(@RequestBody DocumentoEntity documento) {
        DocumentoEntity novoDocumento = documentoService.salvarDocumento(documento);
        return ResponseEntity.ok(novoDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoEntity> atualizarDocumento(@PathVariable String id, @RequestBody DocumentoEntity documento) {
        DocumentoEntity documentoAtualizado = documentoService.atualizarDocumento(id, documento);
        return ResponseEntity.ok(documentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDocumento(@PathVariable String id) {
        documentoService.excluirDocumento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoEntity> buscarDocumentoPorId(@PathVariable String id) {
        DocumentoEntity documento = documentoService.buscarDocumentoPorId(id);
        return ResponseEntity.ok(documento);
    }

    @GetMapping
    public ResponseEntity<List<DocumentoEntity>> listarDocumentos() {
        List<DocumentoEntity> documentos = documentoService.listarDocumentos();
        return ResponseEntity.ok(documentos);
    }
}


