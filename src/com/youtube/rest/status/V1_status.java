package com.youtube.rest.status;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.sql.*;
import com.youtube.dao.*;

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
    
    @Path("/database")
    @GET
    @Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {

		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;

		try {
			conn = OracleDao.OracleDaoConn().getConnection();
			query = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME from sys.dual");

			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				myString = rs.getString("DATETIME");
			}
			query.close();
			returnString = "<p> Databasr Status</p>"
					+ "<p>Database DateTime return: " + myString + "</p>";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();

		}

		return returnString;
	}
}
