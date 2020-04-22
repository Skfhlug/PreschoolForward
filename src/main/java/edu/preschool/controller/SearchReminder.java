package edu.preschool.controller;

import edu.preschool.entity.Reminder;
import edu.preschool.persitence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 *
 * @author Suparin Fhlug
 */
@WebServlet(
        name = "reminder",
        urlPatterns = { "/reminder" }
)
public class SearchReminder extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );
        String  searchType = req.getParameter("searchType" );


        GenericDao genericDao = new GenericDao(Reminder.class);

        if (searchTerm.length()>0 || req.getParameter("submit").equals("Search")) {
            req.setAttribute("resultList", genericDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("reminders", genericDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/reminder.jsp");
        dispatcher.forward(req, resp);
    }
}
