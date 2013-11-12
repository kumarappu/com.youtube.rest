package com.youtube.rest.status;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/status/")
public class V1_status {
	
	private static final  String API_VERSION ="00.01.00";
	
    /**
     * This method sits at the root of the api.  It will return the name
     * of this api.
     * 
     * @return String - Title of the api
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle() {
            return "<p>Java Web Services</p>";
    }
    
    @Path("/version")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnVersion() {
            return "<p>Version:</p>"+API_VERSION;
    }
}
