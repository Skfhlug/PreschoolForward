package edu.preschool.controller;


import edu.preschool.entity.Parent;
import edu.preschool.entity.Report;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(
        name = "addReport",
        urlPatterns = { "/addReport" }
)
public class AddDailyReport extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int student_id = Integer.parseInt(req.getParameter("studentID"));
        int emotion_rate = Integer.parseInt(req.getParameter("emotion-stars"));
        int eating_rate = Integer.parseInt(req.getParameter("eating-stars"));
        int sleeping_rate = Integer.parseInt(req.getParameter("sleeping-stars"));
        String user_name =  req.getRemoteUser();
        String todayDate = req.getParameter("todayDate");


        GenericDao userDao = new GenericDao(User.class);
        GenericDao studentDao = new GenericDao(Student.class);
        GenericDao reportDao = new GenericDao(Report.class);


        User user = (User) userDao.getByPropertyLike("username", user_name).get(0);
        Student student = (Student) studentDao.getById(student_id);

        Report report = new Report();
        report.setId(1);
        report.setStudent(student);
        report.setEmotion(emotion_rate);
        report.setEating(eating_rate);
        report.setSleeping(sleeping_rate);
        report.setUser(user);
        report.setReport_date(todayDate);

        int added_id = reportDao.insert(report);

        logger.info(student_id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("dailyAction?student_class=A&student_grade=Senior");
        dispatcher.forward(req, resp);
    }
}
