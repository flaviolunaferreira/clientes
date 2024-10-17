package the.coyote.clientes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import the.coyote.clientes.model.dto.cliente.ResponseCadastroClienteDTO;
import the.coyote.clientes.model.dto.documento.CadastroDocumentoDTO;
import the.coyote.clientes.model.enumeration.TipoDocumento;
import the.coyote.clientes.service.DocumentoService;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;

    @PostMapping("/{clienteId}")
    public ResponseEntity<ResponseCadastroClienteDTO> adicionarDocumento(@PathVariable String clienteId,  @RequestBody CadastroDocumentoDTO documentoDTO) {
        TipoDocumento tipoDocumento = documentoDTO.getTipoDocumento();
        Class<?> dtoClass = tipoDocumento.getDtoClass();
        Object documento = documentoService.processarDocumento(dtoClass, documentoDTO.getDadosDocumento());

        return ResponseEntity.ok().body(documentoService.adicionarDocumento(clienteId, documento));
    }

}

