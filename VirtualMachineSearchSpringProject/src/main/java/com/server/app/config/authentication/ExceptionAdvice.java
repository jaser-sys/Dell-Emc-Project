package com.server.app.config.authentication;
import com.server.app.model.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(RuntimeException.class)
    public ApiResponse handleNotFoundException(RuntimeException ex) {
	  
        ApiResponse apiResponse = new ApiResponse(400, ex.getMessage(), null);
        return apiResponse;
    }
}
