package edu.preschool.controller;


import edu.preschool.entity.Parent;
import edu.preschool.entity.Student;
import edu.preschool.entity.User;
import edu.preschool.entity.Report;
import edu.preschool.persitence.GenericDao;

import javax.persistence.criteria.CriteriaBuilder;
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
import java.util.List;
import java.util.Map;

@WebServlet(
        name = "dailyReport",
        urlPatterns = { "/dailyReport" }
)
public class DailyReport extends HttpServlet {
    private GenericDao reportDao;
    private GenericDao userDao;
    private GenericDao parentDao;
    private GenericDao studentDao;

    @Override
    public void init() throws ServletException {
        reportDao =  new GenericDao(Report.class);
        userDao = new GenericDao(User.class);
        parentDao = new GenericDao(Parent.class);
        studentDao = new GenericDao(Student.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String parent_username = req.getRemoteUser();
        //Get user id
        User user = (User) userDao.getByPropertyLike("username", parent_username).get(0);
        int user_id = user.getId();

        //Get student id
        Parent parent = (Parent) parentDao.findByPropertyEqual("user", user_id).get(0);
        Student student_info = parent.getStudent();
        int student_id = student_info.getId();

        //Get student name
        Student student = (Student) studentDao.getById(student_id);

        //Display and get Date
        LocalDate todayDate = LocalDate.now();
        req.setAttribute("date", todayDate);
        String reportDate = String.valueOf(todayDate);

        //Map date and student id
        Map<String, Object> student_report = new HashMap<>();
        student_report.put("report_date", reportDate);
        student_report.put("student", student_id);
        //Get Report
        Report report = (Report) reportDao.findByPropertyEqual(student_report).get(0);

        //Get teacher who update report
        //User teacher = (User)

        String output = "parent id: " + user_id + "\nStudent id:" + student_id;

        req.setAttribute("info", output);
        req.setAttribute("parent_id", user_id);
        req.setAttribute("student_id", student_id);
        req.setAttribute("student", student);
        req.setAttribute("report", report);



        RequestDispatcher dispatcher = req.getRequestDispatcher("/dailyReport.jsp");
        dispatcher.forward(req, resp);
    }
}
