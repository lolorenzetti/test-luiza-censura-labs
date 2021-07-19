package br.com.wishlist.resource.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<ApiError> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {

        String error = ex.getMessage();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error);
        return new ResponseEntity<ApiError>(
                apiError, new HttpHeaders(), apiError.getStatus());

    }

}
