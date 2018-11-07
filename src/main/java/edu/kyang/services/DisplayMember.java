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

@Path("/users")
public class DisplayMember {

    @GET
    @Path("/all")
    public Response getAllUsers() throws JsonProcessingException {
        GenericDAO userDAO = new GenericDAO(UserBean.class);

        List<UserBean> usersList = userDAO.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String responseString = mapper.writeValueAsString(usersList);
        return Response.status(200).entity(responseString).build();

    }

}
