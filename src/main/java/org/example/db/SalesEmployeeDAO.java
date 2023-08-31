package org.example.db;

import org.example.cli.SalesEmployeeRequest;

import java.sql.*;

public class SalesEmployeeDAO {
    private final DatabaseConnector databaseConnector = new DatabaseConnector();

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();

        int employeeId = employeeDAO.createEmployee(salesEmployeeRequest.getEmployeeRequest());

        String insertStatement = "INSERT INTO SalesEmployee (EmployeeID,CommissionRate) VALUES (?,?);";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, employeeId);
        st.setDouble(2, salesEmployeeRequest.getCommissionRate());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();

        if(employeeId > -1)
            return employeeId;

        return -1;
    }

}
