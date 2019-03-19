package org.hms4j.example.jaxrs;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/sample")
public class Sample {
    private Map<String, Item> items;

    public Sample() {
        items = Collections.synchronizedMap(new TreeMap<String, Item>(String.CASE_INSENSITIVE_ORDER));
        items.put("Item 1", new Item("Item 1", "Value 1"));
        items.put("Item 2", new Item("Item 2", "Value 2"));
    }


    @Produces({ MediaType.APPLICATION_JSON})
    @GET
    public Response getItems(
        @QueryParam("page") @DefaultValue("1") int page) {

        return Response.ok(items.values()).build();
    }

    @Produces({ MediaType.APPLICATION_JSON})
    @Path("/{name}")
    @GET
    public Item getItem(
        @HeaderParam("Accept-Language") final String language,
        @PathParam("name") String name) {
        return items.get(name);
    }

    @Consumes({ MediaType.APPLICATION_JSON})
    @POST
    public Response createItem(
        @Context final UriInfo uriInfo,
        final Item item) {
        items.put(item.getName(), item);
        return Response
            .created(uriInfo.getBaseUriBuilder().path(item.getName()).build())
            .entity(item).build();
    }

    @Produces({ MediaType.APPLICATION_JSON})
    @Path("/{name}")
    @PUT
    public Item updateItem(
        @PathParam("name") String name,
        @FormParam("value") String value) {
        Item item = new Item(name, value);
        items.put(name,  item);
        return item;
    }

    @Path("/{name}")
    @DELETE
    public Response delete(@PathParam("name") String name) {
        items.remove(name);
        return Response.ok().build();
    }
}
