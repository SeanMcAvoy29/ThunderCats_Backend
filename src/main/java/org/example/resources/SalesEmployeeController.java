package org.example.resources;

import io.swagger.annotations.Api;
import org.example.api.SalesEmployeeService;
import org.example.cli.SalesEmployeeRequest;
import org.example.client.FailedToCreateSalesEmployeeException;
import org.example.client.InvalidSalesEmployeeException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Engineering Academy Dropwizard Employee API")
@Path("/employees")
public class SalesEmployeeController {

    private final SalesEmployeeService salesEmployeeService = new SalesEmployeeService();
    @POST
    @Path("/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {
        try {
            return Response.ok(salesEmployeeService.createSalesEmployee(salesEmployeeRequest)).build();
        } catch (InvalidSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToCreateSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
