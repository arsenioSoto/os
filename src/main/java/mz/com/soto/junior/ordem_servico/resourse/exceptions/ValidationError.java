package mz.com.soto.junior.ordem_servico.resourse.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StanderdError {

	
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessade> errors = new ArrayList<>();

	public ValidationError() {
		super();
		
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		
	}

	public List<FieldMessade> getErrors() {
		return errors;
	}

	public void addError(String fielName, String message) {
		this.errors.add(new FieldMessade(fielName, message));
	}
	
	
	
	

}
