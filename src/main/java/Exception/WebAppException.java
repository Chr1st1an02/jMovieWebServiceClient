/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author D070429
 */
public class WebAppException extends Exception {
    
    private final ExceptionResponse exceptionResponse;

    public WebAppException(ExceptionResponse exceptionResponse) {
        super(exceptionResponse.message);
        this.exceptionResponse = exceptionResponse;
    }

    public ExceptionResponse getExceptionResponse() {
        return this.exceptionResponse;
    }
    
}
