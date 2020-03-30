package edu.preschool.controller;

import edu.preschool.entity.Reminder;
import edu.preschool.entity.Student;
import edu.preschool.persitence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "addStudentServlet",
        urlPatterns = { "/addStudentServlet" }
)
public class addStudentServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("you are in addStudentServlet page");

        Student student = new Student();

        String first_name = req.getParameter("first_name" );
        String middle_name = req.getParameter("middle_name" );
        String last_name = req.getParameter("last_name");
        String address = req.getParameter("address");
        String date_of_birth = req.getParameter("date_of_birth");
        String classRoom= req.getParameter("class_room");
        String grade = req.getParameter("grade");
        String emergency_phone1 = req.getParameter("emergency_phone1");
        String emergency_phone2 = req.getParameter("emergency_phone2");
        //String picture_address = req.getParameter("picture_address");
        String parent_status = req.getParameter("parent_status");
        String gender = req.getParameter("gender");

        student.setId(0);
        student.setFirst_name(first_name);
        student.setMiddle_name(middle_name);
        student.setLast_name(last_name);
        student.setAddress(address);
        student.setDate_of_birth(date_of_birth);
        student.setClass_room(classRoom);
        student.setGrade(grade);
        student.setEmergency_phone1(emergency_phone1);
        student.setEmergency_phone2(emergency_phone2);
        student.setPicture_address("test");
        student.setParent_status(parent_status);
        student.setGender(gender);


        int userId = 1;

        System.out.println("first name : " + first_name);
        System.out.println("middle name : " + middle_name);
        System.out.println("last name : " + last_name);
        System.out.println("address : " + address);
        System.out.println("date of birth : " + date_of_birth);
        System.out.println("class : " + classRoom);
        System.out.println("grade : " + grade);
        System.out.println("emergency phone1 : " + emergency_phone1);
        System.out.println("emergency phone2 : " + emergency_phone2);
        System.out.println("picture address: " + "test");
        System.out.println("parent status: " + parent_status);
        System.out.println(("gender" + gender));



        GenericDao genericDao = new GenericDao(Reminder.class);
        //Student student = new Student(first_name, middle_name, last_name, address, date_of_birth, classRoom, grade, emergency_phone1,emergency_phone2, "test", parent_status, gender);
        int id = genericDao.insert(student);

        System.out.println("student id = " + id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/student.jsp");
        dispatcher.forward(req, resp);
    }
}
