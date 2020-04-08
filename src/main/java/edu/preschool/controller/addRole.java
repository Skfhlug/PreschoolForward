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
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(
        name = "addRole",
        urlPatterns = { "/addRole" }
)
public class addRole  extends HttpServlet{
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Role role = new Role();
        GenericDao genericDao = new GenericDao(Role.class);
        HttpSession session = request.getSession();



        String username = (String) session.getAttribute("added_username");
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getByPropertyLike("username", username).get(0);
        System.out.println("username =" + username);
        System.out.println(user);

        role.setRole_name(request.getParameter("role"));
        role.setUsername(user);
        System.out.println(username);


        int id = genericDao.insert(role);
        session.setAttribute("sessionAdd", "Added User Successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addRole.jsp");
        dispatcher.forward(request, response);
    }
}
