package edu.preschool.controller;

import edu.preschool.entity.Student;
import edu.preschool.entity.User;
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
        urlPatterns = {"/editStudentServlet"}
)
public class EditStudentServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao studentDao;
    @Override
    public void init() throws ServletException {
        studentDao = new GenericDao(Student.class);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        logger.info("Editing Student data\nStudent ID:" + id);

        Student student= (Student) studentDao.getById(id);
        student.setFirst_name(request.getParameter("first_name"));
        student.setMiddle_name(request.getParameter("middle_name"));
        student.setLast_name(request.getParameter("last_name"));
        student.setAddress(request.getParameter("address"));
        student.setClass_room(request.getParameter("class_room"));
        student.setGrade(request.getParameter("grade"));
        student.setEmergency_phone1(request.getParameter("emergency_phone1"));
        student.setEmergency_phone2(request.getParameter("emergency_phone2"));
        student.setParent_status(request.getParameter("parent_status"));

        if(request.getRemoteUser().equals(request.getParameter("username")) || request.isUserInRole("admin")) {
            studentDao.saveOrUpdate(student);

        }
        response.sendRedirect("searchStudent?searchTerm=&searchType=id&submit=viewAll");

    }



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao dao = new GenericDao(User.class);

        //request.setAttribute("editUser",genericDao.getById(Integer.valueOf(request.getParameter("user_id"))));
        request.setAttribute("student", studentDao.getById(Integer.valueOf(request.getParameter("editID"))));
        String url = "/editStudent.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
