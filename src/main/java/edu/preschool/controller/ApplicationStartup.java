package edu.preschool.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/PreschoolForward-startup" },
        loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String active_username = req.getRemoteUser();
        getServletContext().setAttribute("active_username", active_username);
    }
}
