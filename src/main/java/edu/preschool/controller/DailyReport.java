package edu.preschool.controller;


import edu.preschool.entity.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(
        name = "dailyReport",
        urlPatterns = { "/dailyReport" }
)
public class DailyReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao reportDao =  new GenericDao(Report.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao parentDao = new GenericDao(Parent.class);
        GenericDao studentDao = new GenericDao(Student.class);;

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

        List<Report> reports;
        reports = new ArrayList<>(reportDao.findByPropertyEqual(student_report));

        String output = "parent id: " + user_id + "\nStudent id:" + student_id;
        req.setAttribute("info", output);
        req.setAttribute("parent_id", user_id);
        req.setAttribute("student_id", student_id);
        req.setAttribute("student", student);
        req.setAttribute("report", report);

        GenericDao reminderDao = new GenericDao(Reminder.class);
        Reminder reminders = (Reminder) reminderDao.getByPropertyLike("status", "display").get(0);
        System.out.println("reminder" + reminders.getReminder_title());
        req.setAttribute("reminders", reminders);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/dailyReport.jsp");
        dispatcher.forward(req, resp);
    }
/*

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao reportDao =  new GenericDao(Report.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao parentDao = new GenericDao(Parent.class);
        GenericDao studentDao = new GenericDao(Student.class);;

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
        //Report report = (Report) reportDao.findByPropertyEqual(student_report).get(0);

        List<Report> reports;
        reports = new ArrayList<>(reportDao.findByPropertyEqual(student_report));

        String output = "parent id: " + user_id + "\nStudent id:" + student_id;
        req.setAttribute("info", output);
        req.setAttribute("parent_id", user_id);
        req.setAttribute("student_id", student_id);
        req.setAttribute("student", student);
        req.setAttribute("report", reports);
/*
        GenericDao reminderDao = new GenericDao(Reminder.class);
        Reminder reminders = (Reminder) reminderDao.getByPropertyLike("status", "display").get(0);
        req.setAttribute("reminders", reminders);
*//*
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dailyReport.jsp");
        dispatcher.forward(req, resp);
    }*/
}
