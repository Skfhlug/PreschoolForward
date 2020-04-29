package edu.preschool.controller;
import edu.preschool.entity.Parent;
import edu.preschool.persitence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
        name = "searchParent",
        urlPatterns = { "/searchParent" }
)
public class SearchParent extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchTerm = req.getParameter("searchTerm" );
        String searchType = req.getParameter("searchType" );
        String active_username = req.getRemoteUser();
        HttpSession session  = req.getSession();
        session.setAttribute("user", active_username);

        GenericDao genericDao = new GenericDao(Parent.class);

        if (searchTerm.length()>0 || req.getParameter("submit").equals("Search")) {
            req.setAttribute("resultList", genericDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("parents", genericDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/parent.jsp");
        dispatcher.forward(req, resp);
    }
}

