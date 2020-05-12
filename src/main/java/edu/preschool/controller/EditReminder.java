package edu.preschool.controller;


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
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/editReminder"}
)
public class EditReminder extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        GenericDao userDao= new GenericDao(User.class);
        GenericDao reminderDao = new GenericDao(Reminder.class);

        Reminder reminders = (Reminder) reminderDao.getById(id);
        reminders.setReminder_title(request.getParameter("title"));
        reminders.setDescription(request.getParameter("description"));
        reminders.setStatus(request.getParameter("displayStatus"));
        String username = request.getRemoteUser();
        User users = (User) userDao.getByPropertyLike("username", username).get(0);
        reminders.setUser(users);

        if(request.getRemoteUser().equals(request.getParameter("teacher")) || request.isUserInRole("admin")) {
            reminderDao.saveOrUpdate(reminders);
        }
        response.sendRedirect("reminder?searchTerm=&searchType=id&submit=viewAll");

    }



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao reminderDao= new GenericDao(Reminder.class);
        GenericDao dao = new GenericDao(User.class);


        request.setAttribute("reminder", reminderDao.getById(Integer.valueOf(request.getParameter("editID"))));
        String url = "/editReminder.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
