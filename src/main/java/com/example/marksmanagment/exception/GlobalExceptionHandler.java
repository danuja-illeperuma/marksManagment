package com.example.marksmanagment.exception;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String handleBindException(

            BindException e,

            HttpServletRequest request,

            RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute(
                "error",
                "Please enter valid numeric values");

        String previousUrl =
                request.getHeader("Referer");

        return "redirect:" + previousUrl;
    }
}