package nl.han.dea;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/items")
public class ItemResource {

    @GET
    @Produces("text/plain")
    public String items() {
        return "bread, butter";
    }
}
