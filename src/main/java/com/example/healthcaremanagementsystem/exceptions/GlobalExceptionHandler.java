package com.example.healthcaremanagementsystem.exceptions;

import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.error(ex.getMessage());
        return new ApiResponse<>("Failed", ex.getMessage(), null);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<String> handleValidationException(ValidationException ex) {
        logger.error(ex.getMessage());
        return new ApiResponse<>("Failed", "Error: " + ex.getMessage(), null);
    }

    @ExceptionHandler(MailSendingException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ApiResponse<String> handleMailSendingException(MailSendingException ex) {
        logger.error(ex.getMessage());
        return new ApiResponse<>("Failed", "Error: " + ex.getMessage(), null);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse<String> handleUserNotFoundException(UserNotFoundException ex) {
        logger.error(ex.getMessage());
        return new ApiResponse<>("Failed", "Error: " + ex.getMessage(), null);
    }
}



//        @ExceptionHandler(HealthProviderNotFoundException.class)
//        @ResponseStatus(HttpStatus.BAD_REQUEST)
//        @ResponseBody
//        public ApiResponse<String> handleHealthProviderNotFoundException(HealthProviderNotFoundException ex){
//            logger.error(ex.getMessage());
//            return  new ApiResponse<>("Failed","Error: "+ex.getMessage(), null);
//        }

//        @ExceptionHandler(PatientNotFoundException.class)
//        @ResponseStatus(HttpStatus.NOT_FOUND)
//        @ResponseBody
//        public ApiResponse<String> handlePatientNotFoundException(PatientNotFoundException ex){
//            logger.error(ex.getMessage());
//            return  new ApiResponse<>("Failed","Error: "+ex.getMessage(), null);
//        }

//    @ExceptionHandler(EmailNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ApiResponse<String> handleEmailNotFoundException(EmailNotFoundException ex){
//        logger.error(ex.getMessage());
//        return  new ApiResponse<>("Failed","Error: "+ex.getMessage(), null);
//    }
