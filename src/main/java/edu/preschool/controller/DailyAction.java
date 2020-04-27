package edu.preschool.controller;

import edu.preschool.entity.Reminder;
import edu.preschool.entity.Student;
import edu.preschool.persitence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "dailyAction",
        urlPatterns = { "/dailyAction" }
)
public class DailyAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate todayDate = LocalDate.now();
        String student_class = req.getParameter("student_class");
        String student_grade = req.getParameter("student_grade");
        String active_username = req.getRemoteUser();
        HttpSession session  = req.getSession();
        session.setAttribute("user", active_username);

        Map<String, String> studentGroup = new HashMap<String, String>();
        studentGroup.put("class_room", student_class);
        studentGroup.put("grade", student_grade);

        GenericDao genericDao = new GenericDao(Student.class);

        req.setAttribute("students", genericDao.findByPropertyEqual(studentGroup));
        req.setAttribute("date", todayDate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/dailyForm.jsp");
        dispatcher.forward(req, resp);
    }


}
