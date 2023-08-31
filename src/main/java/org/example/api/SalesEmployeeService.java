package org.example.api;

import org.example.cli.SalesEmployeeRequest;
import org.example.client.FailedToCreateSalesEmployeeException;
import org.example.db.SalesEmployeeDAO;

import java.sql.SQLException;

public class SalesEmployeeService {
    private SalesEmployeeDAO salesEmployeeDAO = new SalesEmployeeDAO();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) throws FailedToCreateSalesEmployeeException {
        try {
            int id = salesEmployeeDAO.createSalesEmployee(salesEmployeeRequest);

            if (id == -1)
                throw new FailedToCreateSalesEmployeeException();

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateSalesEmployeeException();
        }
    }
}
