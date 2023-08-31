package org.example.api;

import org.example.cli.Employee;
import org.example.cli.EmployeeRequest;
import org.example.client.EmployeeDoesNotExistException;
import org.example.client.FailedToCreateDeliveryEmployeeException;
import org.example.client.FailedToUpdateEmployeeException;
import org.example.client.InvalidEmployeeException;
import org.example.core.EmployeeValidator;
import org.example.db.DeliveryEmployeeDao;
import org.example.db.EmployeeDAO;

import java.sql.SQLException;

public class DeliveryEmployeeService {

    DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();
    EmployeeDAO employeeDAO = new EmployeeDAO();
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

    public void updateDeliveryEmployee(int id, EmployeeRequest employeeRequest) throws InvalidEmployeeException, EmployeeDoesNotExistException, FailedToUpdateEmployeeException {
        try{
            String validation = employeeValidator.isValidEmployee(employeeRequest);

            if(validation != null){
                throw new InvalidEmployeeException(validation);
            }

            Employee employeeToUpdate = employeeDAO.getEmployeeById(id);

            if(employeeToUpdate == null)
                throw new EmployeeDoesNotExistException();

            deliveryEmployeeDao.updateDeliveryEmployee(id,employeeRequest);
        }catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }
}
