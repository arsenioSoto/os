package mz.com.soto.junior.ordem_servico.resourse.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mz.com.soto.junior.ordem_servico.services.exceptions.ObjecteNotFoundException;
import mz.com.soto.junior.ordem_servico.services.exceptions.DataIntegratyViolationExecption;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjecteNotFoundException.class)
	public ResponseEntity<StanderdError> objectNotFoundExecption(ObjecteNotFoundException e){
		StanderdError error = new StanderdError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegratyViolationExecption.class)
	public ResponseEntity<StanderdError> objectNotFoundExecption(DataIntegratyViolationExecption e){
		StanderdError error = new StanderdError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StanderdError> objectNotFoundExecption(MethodArgumentNotValidException e){
		ValidationError error = new ValidationError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), "Erro na Validacao dos Campos");
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
