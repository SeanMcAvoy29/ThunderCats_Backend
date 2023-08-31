package org.example.db;

import org.example.cli.EmployeeRequest;
import org.example.cli.SalesEmployee;
import org.example.cli.SalesEmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDAO {
    private final DatabaseConnector databaseConnector = new DatabaseConnector();

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT EmployeeID, Name, Salary, BankAccountNumber, NationalInsuranceNumber, CommissionRate " +
                "FROM Employee " +
                "JOIN SalesEmployee USING (EmployeeID);");

        List<SalesEmployee> salesEmployees = new ArrayList<>();

        while (rs.next()) {
            SalesEmployee salesEmployee = new SalesEmployee(
                    rs.getInt("EmployeeID"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber"),
                    rs.getDouble("CommissionRate")
            );

            salesEmployees.add(salesEmployee);
        }

        return salesEmployees;
    }

    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();

        EmployeeRequest employeeRequest = new EmployeeRequest(salesEmployeeRequest.getName(),
                salesEmployeeRequest.getSalary(),
                salesEmployeeRequest.getBankAccNum(),
                salesEmployeeRequest.getNationalInsuranceNum());

        int employeeId = employeeDAO.createEmployee(employeeRequest);

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
