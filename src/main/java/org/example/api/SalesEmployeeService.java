package org.example.api;

import org.example.cli.SalesEmployeeRequest;
import org.example.client.FailedToCreateSalesEmployeeException;
import org.example.client.InvalidSalesEmployeeException;
import org.example.core.SalesEmployeeValidator;
import org.example.db.SalesEmployeeDAO;

import java.sql.SQLException;

public class SalesEmployeeService {
    private SalesEmployeeDAO salesEmployeeDAO = new SalesEmployeeDAO();

    private SalesEmployeeValidator salesEmployeeValidator = new SalesEmployeeValidator();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) throws FailedToCreateSalesEmployeeException, InvalidSalesEmployeeException {
        try {
            String validation = salesEmployeeValidator.isValidSalesEmployee(salesEmployeeRequest);

            if(validation != null ) {
                throw new InvalidSalesEmployeeException(validation);
            }
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
