package com.lijubjohn;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by liju on 2/23/17.
 * Mapper for any rest exception
 */
public class RestException extends Exception implements ExceptionMapper<RestException> {
    public RestException() {
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public Response toResponse(RestException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
