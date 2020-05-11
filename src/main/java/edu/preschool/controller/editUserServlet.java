package edu.preschool.controller;


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
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/editUserServlet"}
)
public class editUserServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao genericDao = new GenericDao(User.class);;
        GenericDao userDao= new GenericDao(User.class);;
        int id = Integer.parseInt(request.getParameter("id"));
        logger.info("Editing user data\n User ID:" + id);

        User user = (User) userDao.getById(id);

        user.setUsername(request.getParameter("username"));
        user.setFirst_name(request.getParameter("first_name"));
        user.setLast_name(request.getParameter("last_name"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        if(request.getRemoteUser().equals(request.getParameter("username")) || request.isUserInRole("admin")) {
            userDao.saveOrUpdate(user);

        }
        response.sendRedirect("searchUser?searchTerm=&searchType=id&submit=viewAll");

    }



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao userDao= new GenericDao(User.class);
        User user = new User();


        //request.setAttribute("editUser",genericDao.getById(Integer.valueOf(request.getParameter("user_id"))));
        request.setAttribute("user", userDao.getById(Integer.valueOf(request.getParameter("editID"))));
        String url = "/editUser.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}