package fca.suayed.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;


import fca.suayed.dal.StoreDal;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clients")
public class ClientsResoruce {
    @Inject
    StoreDal storeDal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all clients")
    @APIResponses(value = {
        @APIResponse(responseCode ="200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
    })
    public Response getClients(){
        var response = storeDal.getClients();
        return Response.ok(response).build();
    }
}
