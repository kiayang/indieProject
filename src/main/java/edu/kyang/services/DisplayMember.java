package edu.kyang.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kyang.entity.UserBean;
import edu.kyang.persistence.GenericDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

//@Path annotation is used to specify the URI through which a resource and an API can be accessed.
//@Path("/hello")
//reference to convert from object to json https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
@Path("/users")
public class DisplayMember {


    //localhost:8080/indieProject/services/users/all <-full path to go to and should return all users
    @GET
    //@Produces({"application/json", "text/plain", "application/xml"})

    /**
    @Path("/all/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "'Jersey say ': '" + msg + "'}";
        return Response.status(200).entity(output).build();

    }
    */

    @Path("/all")
    public Response getAllUsers() throws JsonProcessingException {
        GenericDAO userDAO = new GenericDAO(UserBean.class);

        List<UserBean> usersList = userDAO.getAll(); //this is a List object with all users
        ObjectMapper mapper = new ObjectMapper();
        String responseString = mapper.writeValueAsString(usersList); //this converts your list object to json
        return Response.status(200).entity(responseString).build(); //returns the json string as response -should show on full path i wrote above on line 20

    }


}
