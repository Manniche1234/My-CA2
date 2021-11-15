package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PlayerDTO;
import dtos.UserDTO;
import entities.Player;
import entities.User;
import facades.UserFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("/user")
public class UserResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    @Context
    private UriInfo context;
    private UserFacade facade = UserFacade.getUserFacade(EMF);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    SecurityContext securityContext;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Path("/addplayer")
    public String addPlayerToUser(String DTO){
        String thisuser = securityContext.getUserPrincipal().getName();
        PlayerDTO playerDTO = gson.fromJson(DTO,PlayerDTO.class);
        UserDTO response = facade.addPlayerToUser(thisuser,playerDTO);

        return  "You added a player " + playerDTO.getfirst_name() + " " + playerDTO.getLast_name() + " to user: " + thisuser;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    @Path("/usersplayers")
    public String seeALlUsersPlayer(){
        String thisuser = securityContext.getUserPrincipal().getName();
        UserDTO user = facade.seeAllPlayerWithUserId(thisuser);

        return gson.toJson(user);

    }
}