package the.coyote.clientes.model.enumeration;

import java.util.HashMap;
import java.util.Map;

import the.coyote.clientes.model.dto.documento.CnpjDTO;
import the.coyote.clientes.model.dto.documento.CpfDTO;
import the.coyote.clientes.model.dto.documento.HabilitacaoDTO;
import the.coyote.clientes.model.dto.documento.PassaporteDTO;
import the.coyote.clientes.model.dto.documento.ReservistaDTO;
import the.coyote.clientes.model.dto.documento.RgDTO;

public enum TipoDocumento {

    CPF("CPF", "###.###.###-##", CpfDTO.class),
    RG(new HashMap<>() {{
        put("Número do RG", "###.###.###-#");
        put("Data de Expedição", "dd/MM/yyyy");
        put("Órgão Emissor", "");
        put("Nome do Pai", "");
        put("Nome da Mãe", "");
    }}, RgDTO.class),
    CNPJ("CNPJ", "##.###.###/####-##", CnpjDTO.class),
    HABILITACAO(new HashMap<>() {{
        put("Número da Habilitação", "");
        put("Categoria", "");
        put("Data de Expedição", "");
        put("Data de Expiração", "dd/MM/yyyy");
    }}, HabilitacaoDTO.class),
    RESERVISTA(new HashMap<>() {{
        put("Número da Reservista", "");
        put("Unidade Militar", "");
    }}, ReservistaDTO.class),
    PASSAPORTE(new HashMap<>() {{
        put("Número do Passaporte", "");
        put("País de Emissão", "");
        put("Data de Expiração", "dd/MM/yyyy");
    }}, PassaporteDTO.class);

    private final Map<String, String> campos;
    private final Class<?> dtoClass; // Classe DTO associada

    // Construtor para tipos com vários campos
    TipoDocumento(Map<String, String> campos, Class<?> dtoClass) {
        this.campos = campos;
        this.dtoClass = dtoClass;
    }

    // Construtor para tipos com um único campo
    TipoDocumento(String campo, String mascara, Class<?> dtoClass) {
        this.campos = new HashMap<>();
        this.campos.put(campo, mascara);
        this.dtoClass = dtoClass;
    }

    // Método que retorna os campos
    public Map<String, String> getCampos() {
        return campos;
    }

    // Método para obter a classe DTO associada
    public Class<?> getDtoClass() {
        return dtoClass;
    }
}
