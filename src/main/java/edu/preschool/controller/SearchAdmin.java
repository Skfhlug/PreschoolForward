package edu.preschool.controller;

import edu.preschool.entity.Admin;
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
        name = "searchAdmin",
        urlPatterns = { "/searchAdmin" }
)
public class SearchAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );
        String searchType = req.getParameter("searchType");

        GenericDao genericDao = new GenericDao(Admin.class);
        if (searchTerm.length()>0) {
            req.setAttribute("resultList", genericDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("admins", genericDao.getAll());
        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminResult.jsp");
        dispatcher.forward(req, resp);
    }
}
