package edu.preschool.controller;

import edu.preschool.persitence.AdminDao;

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
        urlPatterns = { "/searchAdmin" }
)
public class SearchAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );
        String searchType = req.getParameter("searchType");

        AdminDao adminDao = new AdminDao();
        if (searchTerm.length()>0) {
            req.setAttribute("resultList", adminDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("users", adminDao.getAll());
        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminResult.jsp");
        dispatcher.forward(req, resp);
    }
}
