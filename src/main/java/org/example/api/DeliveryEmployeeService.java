package org.example.api;

import org.example.cli.EmployeeRequest;
import org.example.client.FailedToCreateDeliveryEmployeeException;
import org.example.db.DeliveryEmployeeDao;
import org.example.db.EmployeeDAO;

import java.sql.SQLException;

public class DeliveryEmployeeService {

    DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();

    public int createDeliveryEmployee(EmployeeRequest employeeRequest) throws FailedToCreateDeliveryEmployeeException {
        try {
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
