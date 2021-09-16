package mz.com.soto.junior.ordem_servico.services.exceptions;

public class DataIntegratyViolationExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationExecption(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataIntegratyViolationExecption(String message) {
		super(message);
		
	}
	
	
	
	
}