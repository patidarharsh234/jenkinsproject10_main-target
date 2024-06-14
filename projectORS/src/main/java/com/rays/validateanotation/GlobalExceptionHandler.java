package com.rays.validateanotation;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		Map<String, Object> errors = new HashMap<>();
//		errors.put("success", false);
//		Map<String, String> inputErrors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			inputErrors.put(fieldName, errorMessage);
//		});
//		errors.put("inputErrors", inputErrors);
//		errors.put("message", "Validation failed");
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
//}
