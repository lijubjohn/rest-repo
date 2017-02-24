package com.lijubjohn;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by liju on 2/23/17.
 * Exception mapper for employee not found exception
 */
@Provider
public class EmployeeNotFoundEx extends Exception implements ExceptionMapper<EmployeeNotFoundEx>{
    public EmployeeNotFoundEx() {
    }

    public EmployeeNotFoundEx(String message) {
        super(message);
    }

    public EmployeeNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }


    @Override
    public Response toResponse(EmployeeNotFoundEx ex) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ex.getMessage())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
