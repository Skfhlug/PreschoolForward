package edu.preschool.controller;

import edu.preschool.entity.Reminder;
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
        name = "addReminderServlet",
        urlPatterns = { "/addReminderServlet" }
)
public class addReminderServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("you are in addReminder page");
        String title = req.getParameter("title" );
        String description = req.getParameter("description" );
        String status = req.getParameter("displayStatus");
        int userId = 1;
        System.out.println("title = " + title);
        System.out.println("description = " + description);
        System.out.println("displayStatus = " + status);
        System.out.println("userID = " + userId);

        GenericDao genericDao = new GenericDao(Reminder.class);
        Reminder reminder = new Reminder(title, description, userId, status);


        int successMessages;
        successMessages = genericDao.insert(reminder);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/reminder.jsp");
        dispatcher.forward(req, resp);
    }
}
