/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devweb.restmedia;

import devweb.meadiathequeweb.Livre;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Administrateur
 */
public class LivreResource {

    private String id;

    /**
     * Creates a new instance of LivreResource
     */
    private LivreResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the LivreResource
     */
    public static LivreResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of LivreResource class.
        return new LivreResource(id);
    }

    /**
     * Retrieves representation of an instance of devweb.restmedia.LivreResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Livre l = Livre.getFromId(id);
        JsonObjectBuilder ob = Json.createObjectBuilder();
        ob.add("titre", l.getTitre());
        ob.add("auteur", l.getAuteur());
        ob.add("pages", l.getNbPage());
        JsonObject jo = ob.build();
        return jo.toString();
    }

    /**
     * PUT method for updating or creating an instance of LivreResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource LivreResource
     */
    @DELETE
    public void delete() {
    }
}
