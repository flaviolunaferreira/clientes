package the.coyote.clientes.model.dto.documento;

import java.util.Collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.entity.DocumentoEntity;
import the.coyote.clientes.model.enumeration.TipoDocumento;

@Data
@NoArgsConstructor
public class ReservistaDTO implements DocumentDto{

    private String numero;
    private String unidadeMilitar;

    @Override
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoEntity = new DocumentoEntity();
        documentoEntity.setTipoDocumento(TipoDocumento.RESERVISTA);
        documentoEntity.setDadosDocumento(Collections.singletonMap("Número", numero));
        documentoEntity.setDadosDocumento(Collections.singletonMap("Unidade Militar", unidadeMilitar));
        return documentoEntity;
    }

}
