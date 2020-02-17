package edu.preschool.util.controller;

import edu.preschool.util.persistence.AdminDao;

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
        name = "searchAdmin",
        urlPatterns = {"/searchAdmin"}
)
public class SearchAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );

        AdminDao adminDao = new AdminDao();
        if (searchTerm!=null) {
            req.setAttribute("resultList", adminDao.getUsersByLastName(searchTerm));
        } else {
            req.setAttribute("users", adminDao.getAllUsers());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminResult.jsp");
        dispatcher.forward(req, resp);
    }
}
