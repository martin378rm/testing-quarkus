package org.martin.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

    @GET
    @Path("world")
    public Response hello(){
        return Response.ok("Hello world 2").build();
    }
}
