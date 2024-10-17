package the.coyote.clientes.model.dto.documento;

import lombok.Data;
import the.coyote.clientes.model.enumeration.TipoDocumento;

import java.util.Map;

@Data
public class CadastroDocumentoDTO {

    private TipoDocumento tipoDocumento;
    private Map<String, String> dadosDocumento;



}