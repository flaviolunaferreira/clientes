package the.coyote.clientes.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import the.coyote.clientes.model.dto.cliente.ResponseCadastroClienteDTO;

@Service
public interface DocumentoService {

    ResponseCadastroClienteDTO adicionarDocumento(String clienteId, Object documento);
    Object processarDocumento(Class<?> dtoClass, Map<String, String> dadosDocumento);
}
