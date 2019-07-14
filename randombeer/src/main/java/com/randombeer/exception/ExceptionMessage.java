package com.randombeer.exception;

public enum ExceptionMessage {

    
    COPY_BEAN_PROPERTIES_ERROR("Random beer copy properties error"),
    
    RANDOM_BEER_NOT_FOUND("Random beer not found");
    
    private String value;
    
    

    private ExceptionMessage(String value) {
        
        this.value = value;
    }
    
    
    public String getValue() {
        
        return this.value;
    }

}
