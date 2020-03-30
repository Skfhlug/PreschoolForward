package edu.preschool.controller;


import edu.preschool.entity.Role;
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



        String successMessage;

        successMessage = "User added.";
        request.setAttribute("message", successMessage);
        logger.info("Added user");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
        dispatcher.forward(request, response);
    }
}
