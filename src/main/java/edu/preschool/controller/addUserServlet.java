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
import java.io.IOException;
import java.nio.file.Files;

@WebServlet(
        name = "addUserServlet",
        urlPatterns = { "/addUserServlet" }
)
public class addUserServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setId(1);
        user.setFirst_name(request.getParameter("first_name"));
        user.setLast_name(request.getParameter("last_name"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));



        GenericDao genericDao = new GenericDao(User.class);
        int id = genericDao.insert(user);;


        HttpSession session = request.getSession();
        session.setAttribute("added_id",id);
        session.setAttribute("added_username", request.getParameter("username"));

        String successMessage;
        String userAddedDetail = "New user was added"
                                + "\nID : " + id
                                + "\nFirst Name: " + request.getParameter("first_name")
                                + "\nLast Name: " + request.getParameter("last_name");

        successMessage = "User added.";
        request.setAttribute("message", successMessage);
        session.setAttribute("sessionAdd", userAddedDetail);
        logger.info("Added user");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/addRole.jsp");
        dispatcher.forward(request, response);
    }
}
