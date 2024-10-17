package the.coyote.clientes.model.dto.documento;

import java.util.Collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.enumeration.TipoDocumento;

@Data
@NoArgsConstructor
public class PassaporteDTO implements DocumentDto {

    private String numero;
    private String paisEmissao;
    private String dataExpiracao;

    @Override
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoEntity = new DocumentoEntity();
        documentoEntity.setTipoDocumento(TipoDocumento.PASSAPORTE);
        documentoEntity.setDadosDocumento(Collections.singletonMap("Número", numero));
        documentoEntity.setDadosDocumento(Collections.singletonMap("País de Emissão", paisEmissao));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Data de Expiração", dataExpiracao));
        return documentoEntity;
    }

}
