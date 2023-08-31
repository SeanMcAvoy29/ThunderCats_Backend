package org.example.api;

import org.example.cli.EmployeeRequest;
import org.example.client.FailedToCreateDeliveryEmployeeException;
import org.example.client.InvalidEmployeeException;
import org.example.core.EmployeeValidator;
import org.example.db.DeliveryEmployeeDao;
import org.example.db.EmployeeDAO;

import java.sql.SQLException;

public class DeliveryEmployeeService {

    DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();
    EmployeeValidator employeeValidator = new EmployeeValidator();

    public int createDeliveryEmployee(EmployeeRequest employeeRequest) throws FailedToCreateDeliveryEmployeeException, InvalidEmployeeException {
        try {
            String validation = employeeValidator.isValidEmployee(employeeRequest);

            if(validation != null){
                throw new InvalidEmployeeException(validation);
            }

            int id = deliveryEmployeeDao.createDeliveryEmployee(employeeRequest);

            if (id == -1){
                throw new FailedToCreateDeliveryEmployeeException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateDeliveryEmployeeException();
        }

    }
}
