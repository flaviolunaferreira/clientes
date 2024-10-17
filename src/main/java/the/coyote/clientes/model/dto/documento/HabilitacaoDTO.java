package the.coyote.clientes.model.dto.documento;

import java.util.Collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.enumeration.TipoDocumento;

@Data
@NoArgsConstructor
public class HabilitacaoDTO implements DocumentDto {

    private String numero;
    private String categoria;
    private String dataExpedicao;
    private String dataExpiracao;

    @Override
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoEntity = new DocumentoEntity();
        documentoEntity.setTipoDocumento(TipoDocumento.HABILITACAO);
        documentoEntity.setDadosDocumento(Collections.singletonMap("Número", numero));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Categoria", categoria));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Data Expedição", dataExpedicao));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Data Expiração", dataExpiracao));
        return documentoEntity;
    }

}
