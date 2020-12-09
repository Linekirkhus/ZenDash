package com.zendashproject.demo.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${message.error.exception}")
    private String exceptionMessage;

    @Value("${message.error.duplicate.user}")
    private String duplicateUserMessage;

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler (HttpServletRequest request , Exception e ) {
        ModelAndView modelAndView = new ModelAndView ();
        modelAndView.getModel ().put ( "message" , exceptionMessage );
        modelAndView.getModel ().put ( "url" , request.getRequestURL () );
        modelAndView.getModel ().put ( "exception" , e );
        modelAndView.setViewName ( "exception" );
        return modelAndView;
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ModelAndView duplicateUserHandler ( HttpServletRequest request , Exception e ) {
        ModelAndView modelAndView = new ModelAndView ();
        modelAndView.getModel ().put ( "message" , duplicateUserMessage );
        modelAndView.getModel ().put ( "url" , request.getRequestURL () );
        modelAndView.getModel ().put ( "exception" , e );
        modelAndView.setViewName ( "exception" );
        return modelAndView;
    }
}
