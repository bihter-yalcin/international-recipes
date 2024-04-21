package com.playbook.internationalrecipes.exceptions;

public class DuplicateAuthorException extends RuntimeException{
    public DuplicateAuthorException(String message){
        super(message);
    }

}
