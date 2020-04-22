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
import java.util.List;

@WebServlet(
        name = "searchUser",
        urlPatterns = { "/searchUser" }
)
public class SearchUser extends HttpServlet{

    private GenericDao userDao;

    @Override
    public void init() throws ServletException {
        userDao =  new GenericDao(User.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );
        String  searchType = req.getParameter("searchType" );

        GenericDao genericDao = new GenericDao(User.class);

        String active_username = req.getRemoteUser();
        HttpSession session  = req.getSession();
        session.setAttribute("user", active_username);

        List<User> users = genericDao.getAll();
        req.setAttribute("users", users);


        if (searchTerm.length()>0 || req.getParameter("submit").equals("Search")) {
            req.setAttribute("resultList", genericDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("users", genericDao.getAll());
        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
        dispatcher.forward(req, resp);
    }
}
