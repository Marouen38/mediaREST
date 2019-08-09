/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devweb.restmedia;

import devweb.meadiathequeweb.Livre;
import devweb.meadiathequeweb.Media;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Administrateur
 */
@Path("listelivre")
public class ListelivreResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ListelivreResource
     */
    public ListelivreResource() {
    }

    /**
     * Retrieves representation of an instance of
     * devweb.basedonnee.ListelivreResource
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
            jb.add( ob1.add("id",i));
        }
        ob.add("liste",jb);
        JsonObject jo = ob.build();
        return jo.toString();
    }

    /**
     * PUT method for updating or creating an instance of ListelivreResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
