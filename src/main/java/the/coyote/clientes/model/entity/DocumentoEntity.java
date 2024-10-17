package the.coyote.clientes.model.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.clientes.model.enumeration.TipoDocumento;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoEntity {

    private TipoDocumento tipoDocumento;
    private Map<String, String> dadosDocumento;

}