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
import javax.ws.rs.client.WebTarget;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/editUserServlet"}
)
public class editUserServlet extends HttpServlet {
    private GenericDao genericDao;
    @Override
    public void init() throws ServletException {
        genericDao = new GenericDao(User.class);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao dao = new GenericDao(User.class);
        User user = new User();


        //request.setAttribute("editUser",genericDao.getById(Integer.valueOf(request.getParameter("user_id"))));
        request.setAttribute("user", genericDao.getById(Integer.valueOf(request.getParameter("editID"))));
        String url = "/editUser.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //User user = new User();
        int user_id = Integer.valueOf(request.getParameter("id"));
        User user = (User) genericDao.getById(user_id);


        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setFirst_name(request.getParameter("first_name"));
        user.setLast_name(request.getParameter("last_name"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        System.out.println("Id : " + Integer.valueOf(request.getParameter("id")));
        System.out.println("username : " + request.getParameter("username"));
        System.out.println("first_name : " + request.getParameter("first_name"));
        System.out.println("last_name : " + request.getParameter("last_name"));
        System.out.println("email : " + request.getParameter("email"));
        System.out.println("phone : " + request.getParameter("phone"));



        //GenericDao genericDao = new GenericDao(User.class);
        genericDao.saveOrUpdate(user);;


        HttpSession session = request.getSession();
        session.setAttribute("added_username", request.getParameter("username"));

        String successMessage;
        String userAddedDetail = "New user was changed"
                + "\nFirst Name: " + request.getParameter("first_name")
                + "\nLast Name: " + request.getParameter("last_name");

        successMessage = "User changed.";
        request.setAttribute("message", successMessage);
        session.setAttribute("sessionAdd", userAddedDetail);




        RequestDispatcher dispatcher = request.getRequestDispatcher("/addRole.jsp");
        dispatcher.forward(request, response);
    }
}
