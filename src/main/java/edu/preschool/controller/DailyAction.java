package edu.preschool.controller;

import edu.preschool.entity.Parent;
import edu.preschool.entity.Reminder;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sun.jvm.hotspot.gc.cms.AdaptiveFreeList.sizeOf;

@WebServlet(
        name = "dailyAction",
        urlPatterns = { "/dailyAction" }
)
public class DailyAction extends HttpServlet {
    private List<Student> studentInClass;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int student_id = Integer.parseInt(req.getParameter("studentID"));
        int emotion_rate = Integer.parseInt(req.getParameter("emotion-stars"));
        int eating_rate = Integer.parseInt(req.getParameter("emotion-stars"));
        int sleeping_rate = Integer.parseInt(req.getParameter("emotion-stars"));


        logger.info(student_id);



        //RequestDispatcher dispatcher = req.getRequestDispatcher("searchParent?searchTerm=&searchType=id&submit=viewAll");
        //dispatcher.forward(req, resp);


        //RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        //dispatcher.forward(req, resp);
    }


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

        studentInClass = new ArrayList<>(genericDao.findByPropertyEqual(studentGroup));

        req.setAttribute("students", genericDao.findByPropertyEqual(studentGroup));
        req.setAttribute("date", todayDate);
        req.setAttribute("numberOfStudent", studentInClass.size());

        for(int i=0; i<studentInClass.size(); i++) {

        }

        //RequestDispatcher dispatcher = req.getRequestDispatcher("/dailyForm.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dailyRateForm.jsp");
        dispatcher.forward(req, resp);
    }


}
