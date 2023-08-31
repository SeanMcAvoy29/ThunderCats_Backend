package org.example.db;

import org.example.cli.EmployeeRequest;

import java.sql.*;

public class DeliveryEmployeeDao {

    private final DatabaseConnector databaseConnector = new DatabaseConnector();
    private EmployeeDAO employeeDao = new EmployeeDAO();

    public int createDeliveryEmployee(EmployeeRequest employeeRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();

        int employeeId = employeeDao.createEmployee(employeeRequest);

        if(employeeId == -1){
            return -1;
        }

        String insertStatement = "INSERT INTO DeliveryEmployee (EmployeeID) VALUES (?);";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, employeeId );

        st.executeUpdate();

        return employeeId;
    }


}
