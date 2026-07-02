package com.example.demo_c12.repository;


import com.example.demo_c12.dto.StudentDto;
import com.example.demo_c12.entity.Student;
import com.example.demo_c12.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String SELECT_ALL = "select s.id,s.name,s.gender, c.name as class_name from students s join classes c on s.class_id= c.id;";
    private final String SEARCH_BY_NAME = "select s.id,s.name,s.gender, c.name as class_name from students s join classes c on s.class_id= c.id where s.name like ?";
    private final String SEARCH_BY_NAME_AND_CLASS = "select s.id,s.name,s.gender, c.name as class_name from students s join classes c on s.class_id= c.id where s.name like ? and c.id = ?;";
    private final String INSERT_INTO = "insert into students(name,gender,score,class_id) values(?,?,?,?);";
    private final String DELETE_BY_ID = "delete from students where id = ?;";


    @Override
    public List<StudentDto> findAll() {
        List<StudentDto> studentDtoList =  new ArrayList<>();
        try(Connection connection = ConnectDB.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                String className = resultSet.getString("class_name");
                StudentDto studentDto = new StudentDto(id,name,gender,className);
                studentDtoList.add(studentDto);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> search(String searchName, String classId) {
        List<StudentDto> studentDtoList =  new ArrayList<>();
        try(Connection connection = ConnectDB.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME_AND_CLASS);
        ) {
            preparedStatement.setString(1,"%"+searchName+"%");
            preparedStatement.setString(2,classId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                String className = resultSet.getString("class_name");
                StudentDto studentDto = new StudentDto(id,name,gender,className);
                studentDtoList.add(studentDto);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> search(String searchName) {
        List<StudentDto> studentDtoList =  new ArrayList<>();
        try(Connection connection = ConnectDB.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
        ) {
            preparedStatement.setString(1,"%"+searchName+"%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                String className = resultSet.getString("class_name");
                StudentDto studentDto = new StudentDto(id,name,gender,className);
                studentDtoList.add(studentDto);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentDtoList;
    }

    @Override
    public boolean add(Student student) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try(Connection connection = ConnectDB.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        ) {
            preparedStatement.setInt(1,id);
           int effectRow = preparedStatement.executeUpdate();
           return effectRow ==1;
        }catch (SQLException e) {
            System.out.println(" lỗi kết nối DB");
        }
        return false;
    }
}
