package the.coyote.clientes.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

	private Long timestamp;
	private Integer status;
	private String error;

}
