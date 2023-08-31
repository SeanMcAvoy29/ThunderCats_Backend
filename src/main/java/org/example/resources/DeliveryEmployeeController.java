package org.example.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import org.example.api.DeliveryEmployeeService;
import org.example.cli.EmployeeRequest;
import org.example.client.FailedToCreateDeliveryEmployeeException;
import org.example.client.InvalidEmployeeException;

@Api("Delivery API")
@Path("/employees")
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
}
