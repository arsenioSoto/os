package mz.com.soto.junior.ordem_servico.services.exceptions;

public class ObjecteNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjecteNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjecteNotFoundException(String message) {
		super(message);
		
	}
	
	
	
	
}
