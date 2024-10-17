package the.coyote.clientes.model.dto.documento;

import java.util.Collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.enumeration.TipoDocumento;

@Data
@NoArgsConstructor
public class CpfDTO implements DocumentDto {

    private String numero;

    @Override
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoEntity = new DocumentoEntity();
        documentoEntity.setTipoDocumento(TipoDocumento.CPF);
        documentoEntity.setDadosDocumento(Collections.singletonMap("Número", numero));
        return documentoEntity;
    }

}
