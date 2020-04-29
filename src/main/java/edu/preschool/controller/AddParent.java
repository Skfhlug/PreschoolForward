package edu.preschool.controller;


import edu.preschool.entity.Parent;
import edu.preschool.entity.Student;
import edu.preschool.entity.User;
import edu.preschool.persitence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "addParent",
        urlPatterns = { "/addParent" }
)
public class AddParent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //User user = new User();
        //Student student = new Student();
        Parent parent = new Parent();

        int user_id = Integer.parseInt(req.getParameter("user_id"));
        String username = req.getParameter("username");
        String studentID = req.getParameter("studentID");


        GenericDao userDao = new GenericDao(User.class);
        GenericDao studentDao = new GenericDao(Student.class);
        req.setAttribute("students", studentDao.getAll());

        User user = (User) userDao.getById(user_id);
        Student student = (Student) studentDao.getById(Integer.parseInt(studentID));

        parent.setStudent(student);
        parent.setUser(user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addParentSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
