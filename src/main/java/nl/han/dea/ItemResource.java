package nl.han.dea;

import com.sun.mail.imap.protocol.Item;
import nl.han.dea.services.ItemService;
import nl.han.dea.services.dto.ItemDTO;
import nl.han.dea.services.exceptions.ItemNotAvailableException;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

//@Singleton
@Path("/items")
public class ItemResource {
    private ItemService itemService;

    public ItemResource(){
        this.itemService = new ItemService();
    }

    @GET
    @Produces("text/plain")
    public String getAllItemsAsText() {
        return "bread, butter";
    }

    @GET
    @Produces("application/json")
    public Response getAllItemsAsJson(){
        return Response.ok().entity(itemService.getAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getItemByIdAsJson(@PathParam("id") int id){
        return Response.ok().entity(itemService.getItem(id)).build();
    }

    @POST
    @Consumes("application/json")
    public Response insertItem(ItemDTO item){
        itemService.addItem(item);
        return Response.status(Response.Status.CREATED).build();
    }


}

