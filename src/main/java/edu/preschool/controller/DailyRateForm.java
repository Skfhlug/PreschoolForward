package edu.preschool.controller;


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
import java.io.IOException;

@WebServlet(
        name = "dailyRateForm",
        urlPatterns = { "/dailyRateForm" }
)
public class DailyRateForm extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        int totalStudent = Integer.parseInt(req.getParameter("totalStudent"));
        String todayDate = req.getParameter("todayDate");
        String user_name =  req.getRemoteUser();


        GenericDao userDao = new GenericDao(User.class);
        GenericDao studentDao = new GenericDao(Student.class);
        GenericDao reportDao = new GenericDao(Report.class);


        User user = (User) userDao.getByPropertyLike("username", user_name).get(0);



        for (int i=0;i<totalStudent;i++) {
            String index = String.valueOf(i);
            String studentIndex = "studentID"+ index;
            String emotionInputName = "emotion"+ index;
            String eatingInputName = "eating"+ index;
            String sleepingInputName = "sleeping"+ index;
            int student_id = Integer.parseInt(req.getParameter(studentIndex));
            int emotion_rate = Integer.parseInt(req.getParameter(emotionInputName));
            int eating_rate = Integer.parseInt(req.getParameter(eatingInputName));
            int sleeping_rate = Integer.parseInt(req.getParameter(sleepingInputName));

            logger.info("student id: " + student_id);
            logger.info("emotionInput name: " + emotionInputName+ "  emotion rate: " + emotion_rate);
            logger.info("eatingInput name: " + eatingInputName+ "  eating rate: " + eating_rate);
            logger.info("sleepingInput name: " + sleepingInputName+ "  sleeping rate: " + sleeping_rate);



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
        }



        //logger.info(student_id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/successfulAddingDailyReport.jsp");
        dispatcher.forward(req, resp);
    }
}
