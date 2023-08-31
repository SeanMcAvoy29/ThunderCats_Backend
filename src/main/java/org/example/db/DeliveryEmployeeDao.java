package org.example.db;

import org.example.cli.Employee;
import org.example.cli.EmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void updateDeliveryEmployee(int id, EmployeeRequest employeeRequest) throws SQLException{
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE `Employee` SET `Name` = ?, `Salary` = ?, `BankAccountNumber` = ?, `NationalInsuranceNumber` = ? WHERE EmployeeID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employeeRequest.getName());
        st.setDouble(2, employeeRequest.getSalary());
        st.setString(3, employeeRequest.getBankAccNum());
        st.setString(4, employeeRequest.getNationalInsuranceNum());
        st.setInt(5, id);

        st.executeUpdate();
    }

    public List<Employee> getAllDeliveryEmployees() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Employee.EmployeeID, Name, Salary, BankAccountNumber, NationalInsuranceNumber FROM `Employee` RIGHT JOIN DeliveryEmployee on Employee.EmployeeID = DeliveryEmployee.EmployeeID");
        List<Employee> deliveryEmployeeList = new ArrayList<>();

        while (rs.next()){
            Employee emp = new Employee(
                    rs.getInt("EmployeeID"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber")
            );

            deliveryEmployeeList.add(emp);
        }

        return deliveryEmployeeList;
    }

    public Employee getEmployeeById(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Employee.EmployeeID, Name, Salary, BankAccountNumber, NationalInsuranceNumber FROM `Employee` where EmployeeID="+id);

        while(rs.next()){
            return new Employee(
                    rs.getInt("EmployeeID"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber")
            );
        }
        return null;
    }


}
