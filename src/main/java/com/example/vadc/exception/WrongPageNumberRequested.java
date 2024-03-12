package com.example.vadc.exception;

public class WrongPageNumberRequested extends RuntimeException{
    public WrongPageNumberRequested(String message)
    {
        super(message);
    }
}
