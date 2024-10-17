package the.coyote.clientes.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import the.coyote.clientes.exception.NotFound;
import the.coyote.clientes.model.dto.cliente.ResponseCadastroClienteDTO;
import the.coyote.clientes.model.dto.documento.DocumentDto;
import the.coyote.clientes.model.entity.ClientesEntity;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.repository.ClientesRepository;
import the.coyote.clientes.service.DocumentoService;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {

    private final ClientesRepository clienteRepository;

@Override
public ResponseCadastroClienteDTO adicionarDocumento(String clienteId, Object documento) {
    ClientesEntity cliente = buscarClientePorId(clienteId);

    if (documento instanceof DocumentoEntity) {
        cliente.getDocumentos().add((DocumentoEntity) documento);
    } else if (documento instanceof DocumentDto) {
        cliente.getDocumentos().add(((DocumentDto) documento).toEntity());
    } else {
        throw new IllegalArgumentException("Tipo de documento inválido");
    }

    clienteRepository.save(cliente);  // Salva o cliente atualizado no banco de dados
    return new ResponseCadastroClienteDTO(cliente);  // Retorna o DTO com os dados atualizados
}


    @Override
    public Object processarDocumento(Class<?> dtoClass, Map<String, String> dadosDocumento) {
        // Usar uma biblioteca como Jackson ou Gson para converter o Map<String, String> para o DTO apropriado
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(dadosDocumento, dtoClass);
    }



    private ClientesEntity buscarClientePorId(String clienteId) throws NotFound {
        return clienteRepository.findById(clienteId).orElseThrow(() -> new NotFound("Sinto muito!!! não encontrei o cliete com o id :" + clienteId));
    }

}
