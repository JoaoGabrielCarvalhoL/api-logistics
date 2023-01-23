package br.com.carv.logistics.exception.handler;

import br.com.carv.logistics.exception.BusinessException;
import br.com.carv.logistics.exception.EmailUnavailableException;
import br.com.carv.logistics.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAPI extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        List<FieldErrorResponse> errors = new ArrayList<FieldErrorResponse>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.add(new FieldErrorResponse(field, message));
        }

        ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse(LocalDateTime.now(),
                ex.getMessage(), status.value(), ex.getTitleMessageCode(), errors);
        return handleExceptionInternal(ex, exceptionHandlerResponse, headers, status, request);
    }

    @ExceptionHandler(EmailUnavailableException.class)
    public ResponseEntity<Object> handleEmailUnavailable(EmailUnavailableException emailUnavailableException, WebRequest request) {
        ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse(LocalDateTime.now(),
                emailUnavailableException.getMessage(), HttpStatus.BAD_REQUEST.value(), emailUnavailableException.getClass().getSimpleName());
        return handleExceptionInternal(emailUnavailableException, exceptionHandlerResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
        ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse(LocalDateTime.now(),
                resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), resourceNotFoundException.getClass().getSimpleName());
        return handleExceptionInternal(resourceNotFoundException, exceptionHandlerResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleResourceNotFound(BusinessException businessException, WebRequest request) {
        ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse(LocalDateTime.now(),
                businessException.getMessage(), HttpStatus.BAD_REQUEST.value(), businessException.getClass().getSimpleName());
        return handleExceptionInternal(businessException, exceptionHandlerResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
