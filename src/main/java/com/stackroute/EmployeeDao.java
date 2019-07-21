package com.stackroute;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.ResultSetExtractor;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //insert method
    public int insertIntoemployee(Employee employee){
        String query="insert into employee values('"+employee.getEmployeeId()+"','"+employee.getEmployeeName()+"','"+employee.getEmployeeAge()+"','"+employee.getGender()+"')";
        return jdbcTemplate.update(query);
    }
    //update details based on id
    public int updateEmployee(Employee employee){
        String query="update employee set employeeName='"+employee.getEmployeeName()+"',employeeAge='"+employee.getEmployeeAge()+"',gender='"+employee.getGender()+"' where employeeId='"+employee.getEmployeeId()+"' ";
        return jdbcTemplate.update(query);

        }
//delete details based on id
    public int deleteEmployee(Employee employee){
        String query="delete from employee where employeeId='"+employee.getEmployeeId()+"' ";
        return jdbcTemplate.update(query);
    }
    //retrive details
    public List<Employee> retriveEmployees(){
        String query="select * from employee";
        final List<Employee> list = new ArrayList<Employee>();
       return jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>(){

            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {


                while (resultSet.next()) {
                    Employee e = new Employee();
                    e.setEmployeeId(resultSet.getInt(1));
                    e.setEmployeeName(resultSet.getString(2));
                    e.setEmployeeAge(resultSet.getInt(3));
                    e.setGender(resultSet.getString(4));
                    list.add(e);
                }
                return list;
            }
        });

    }
}
