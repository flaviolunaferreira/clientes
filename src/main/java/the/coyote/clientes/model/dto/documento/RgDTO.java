package the.coyote.clientes.model.dto.documento;

import java.util.Collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.enumeration.TipoDocumento;

@Data
@NoArgsConstructor
public class RgDTO implements DocumentDto {

    private String numero;
    private String dataExpedicao;
    private String orgaoEmissor;
    private String nomePai;
    private String nomeMae;

    @Override
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoEntity = new DocumentoEntity();
        documentoEntity.setTipoDocumento(TipoDocumento.RG);
        documentoEntity.setDadosDocumento(Collections.singletonMap("Número", numero));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Data de Expedição", dataExpedicao));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Orgão Emissor", orgaoEmissor));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Nome do Pai", nomePai));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Nome da Mãe", nomeMae));
        return documentoEntity;
    }

}
