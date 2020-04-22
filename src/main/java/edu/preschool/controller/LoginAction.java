package edu.preschool.controller;

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

@WebServlet(
        urlPatterns = {"/loginAction"}
)
public class LoginAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("The logged in user: " + req.getRemoteUser() + " has a role of admin: " + req.isUserInRole("admin"));
        System.out.println("The logged in user: " + req.getRemoteUser() + " has a role of admin: " + req.isUserInRole("admin"));

        String active_username = req.getRemoteUser();

        HttpSession session  = req.getSession();
        session.setAttribute("active_user", active_username);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/welcomeAdmin.jsp");
        dispatcher.forward(req, resp);
        //resp.sendRedirect("/welcomeAdmin.jsp");
    }

}
