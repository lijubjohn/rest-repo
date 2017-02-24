package com.lijubjohn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by liju on 2/22/17.
 * Simple Rest service to return hello world !
 *
 * Url to invoke this service  : http://localhost:8080/service/hello
 */
@Path("/service")
public class HelloWS {
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String available() {
        return "Hello World !";
    }
}
