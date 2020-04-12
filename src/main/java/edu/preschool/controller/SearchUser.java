package edu.preschool.controller;


import edu.preschool.entity.User;
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
        name = "searchUser",
        urlPatterns = { "/searchUser" }
)
public class SearchUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );
        String  searchType = req.getParameter("searchType" );

        String active_username = req.getRemoteUser();
        //req.setAttribute("user", active_username);
        HttpSession session  = req.getSession();
        session.setAttribute("user", active_username);


        GenericDao genericDao = new GenericDao(User.class);

        if (searchTerm.length()>0) {
            req.setAttribute("resultList", genericDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("users", genericDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
        dispatcher.forward(req, resp);
    }
}
