package edu.preschool.controller;


import edu.preschool.entity.User;
import edu.preschool.persitence.GenericDao;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        GenericDao genericDao = new GenericDao(User.class);
        //User user = new User(0, firstName, lastName, username, password, email, phone);
        String successMessage;
        //genericDao.insert(user);
        successMessage = "User added.";
        request.setAttribute("message", successMessage);


        RequestDispatcher dispatcher = request.getRequestDispatcher("searchUser?searchTerm=&submit=viewAll");
        dispatcher.forward(request, response);
    }
}
