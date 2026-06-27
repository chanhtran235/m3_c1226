package com.example.demo_c12.controller;

import com.example.demo_c12.dto.StudentDto;
import com.example.demo_c12.entity.Student;
import com.example.demo_c12.service.ClassService;
import com.example.demo_c12.service.IClassService;
import com.example.demo_c12.service.IStudentService;
import com.example.demo_c12.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showFormAdd(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
            default:
                showList(req,resp);
        }

    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/view/student/add.jsp").forward(req,resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentDto> studentDtoList = studentService.findAll();
        req.setAttribute("studentList",studentDtoList);
//        req.setAttribute("classList",classService.findAll());
        req.getRequestDispatcher("/view/student/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                save(req,resp);
                break;
            case "delete":
                deleteById(req,resp);
                break;
            default:

        }
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
     int deleteId = Integer.parseInt(req.getParameter("deleteId"));
     boolean isSuccess = studentService.deleteById(deleteId);
        try {
            resp.sendRedirect("/student?mess="+isSuccess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void save(HttpServletRequest req, HttpServletResponse resp) {

    }
}
