package org.example.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import org.example.api.DeliveryEmployeeService;
import org.example.cli.EmployeeRequest;
import org.example.client.*;

@Api("Delivery API")
@Path("/deliveryemployees")
public class DeliveryEmployeeController {
    private DeliveryEmployeeService deliveryEmployeeService = new DeliveryEmployeeService();

    @POST
    @Path("/add-delivery-employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(EmployeeRequest employeeRequest){
        try {
            return Response.ok(deliveryEmployeeService.createDeliveryEmployee(employeeRequest)).build();
        }catch (FailedToCreateDeliveryEmployeeException e){
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }catch (InvalidEmployeeException e){
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(@PathParam("id")int id, EmployeeRequest employeeRequest){
        try {
            deliveryEmployeeService.updateDeliveryEmployee(id, employeeRequest);
            return Response.ok().build();
        }catch (InvalidEmployeeException | EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (FailedToUpdateEmployeeException e){
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployees(){
        try {
            return Response.ok(deliveryEmployeeService.getAllDeliveryEmployees()).build();
        } catch (FailedToGetEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(@PathParam("id")int id){
        try{
            return Response.ok(deliveryEmployeeService.getDeliveryEmployeeById(id)).build();
        }catch(FailedToGetEmployeeException e){
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }catch (EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
