package org.example.resources;

import io.swagger.annotations.Api;
import org.example.api.SalesEmployeeService;
import org.example.cli.SalesEmployeeRequest;
import org.example.client.FailedToCreateSalesEmployeeException;
import org.example.client.FailedToGetSalesEmployeesException;
import org.example.client.InvalidSalesEmployeeException;
import org.example.client.SalesEmployeeDoesNotExistException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Engineering Academy Dropwizard Employee API")
@Path("/employees")
public class SalesEmployeeController {

    private final SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

    @GET
    @Path("/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployees() {
        try {
            return Response.ok(salesEmployeeService.getAllSalesEmployee()).build();
        } catch (FailedToGetSalesEmployeesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @GET
    @Path("/sales/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployees(@PathParam("id") int id) {
        try {
            return Response.ok(salesEmployeeService.getSalesEmployeeById(id)).build();
        } catch (SalesEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (FailedToGetSalesEmployeesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

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
