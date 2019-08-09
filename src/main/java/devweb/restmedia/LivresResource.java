/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devweb.restmedia;

import devweb.meadiathequeweb.Livre;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Administrateur
 */
@Path("/Livres")
public class LivresResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LivresResource
     */
    public LivresResource() {
    }

    /**
     * Retrieves representation of an instance of
     * devweb.restmedia.LivresResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        ArrayList<Integer> ids = Livre.getAllId();
        JsonObjectBuilder ob = Json.createObjectBuilder();
        JsonArrayBuilder jb = Json.createArrayBuilder();
        for (Integer i : ids) {
            JsonObjectBuilder ob1 = Json.createObjectBuilder();
            jb.add(ob1.add("id", i));
        }
        ob.add("liste", jb);
        JsonObject jo = ob.build();
        return jo.toString();
    }

    /**
     * POST method for creating an instance of LivreResource
     *
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public LivreResource getLivreResource(@PathParam("id") String id) {
        return LivreResource.getInstance(id);
    }
}
