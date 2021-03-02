package nl.han.dea;

import nl.han.dea.services.ItemService;
import nl.han.dea.services.dto.ItemDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/items")
public class ItemResource {
    private ItemService itemService;

    public ItemResource(){
        this.itemService = new ItemService();
    }

    @GET
    @Produces("text/plain")
    public String itemsAsText() {
        return "bread, butter";
    }

    @GET
    @Produces("application/json")
    public Response itemsAsJson(){
        return Response.ok().entity(itemService.getAll()).build();
    }
}
