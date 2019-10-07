package saola.com.ngheluon.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import saola.com.ngheluon.dto.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    ResponseDTO responseDTO = ResponseDTO.builder().status(status.value()).message(ex.getMessage()).build();
    return ResponseEntity.badRequest().body(responseDTO);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    FieldError fieldError = ex.getBindingResult().getFieldError();
    ResponseDTO responseDTO = ResponseDTO.builder().status(status.value())
        .message(fieldError.getField() + " " + fieldError.getDefaultMessage()).build();

    return ResponseEntity.badRequest().body(responseDTO);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public final ResponseEntity<Object> handleIllegalArgumentExceptionException(Exception ex, WebRequest request) {
    ResponseDTO responseDTO = ResponseDTO.builder().status(HttpStatus.BAD_REQUEST.value()).message(ex.getMessage())
        .build();
    return ResponseEntity.badRequest().body(responseDTO);
  }

  @ExceptionHandler({ ResourceNotFoundException.class, EmptyResultDataAccessException.class })
  public ResponseEntity<?> resourceNotFoundException(Exception ex, WebRequest request) {
    ResponseDTO responseDTO = ResponseDTO.builder().status(HttpStatus.NOT_FOUND.value()).message(ex.getMessage())
        .build();

    return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGeneralException(Exception ex, WebRequest request) {
    ResponseDTO responseDTO = ResponseDTO.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message(ex.getMessage()).build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(responseDTO);
  }
}