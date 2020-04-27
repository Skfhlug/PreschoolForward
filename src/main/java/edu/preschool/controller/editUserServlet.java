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
    private GenericDao userDao;
    @Override
    public void init() throws ServletException {
        genericDao = new GenericDao(User.class);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userDao = new GenericDao(User.class);
        String user_name = request.getParameter("username");
        User user = (User) userDao.getByPropertyLike("username", user_name);


        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setUsername(request.getParameter("username").trim());
        user.setFirst_name(request.getParameter("first_name").trim());
        user.setLast_name(request.getParameter("last_name").trim());
        user.setPassword(request.getParameter("password").trim());
        user.setEmail(request.getParameter("email").trim());
        user.setPhone(request.getParameter("phone").trim());
        System.out.println("Id : " + Integer.valueOf(request.getParameter("id").trim()));
        System.out.println("username : " + request.getParameter("username"));
        System.out.println("first_name : " + request.getParameter("first_name").trim());
        System.out.println("last_name : " + request.getParameter("last_name").trim());
        System.out.println("email : " + request.getParameter("email").trim());
        System.out.println("phone : " + request.getParameter("phone").trim());

        /*User user = new User(Integer.valueOf(request.getParameter("id")),
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("email"),
                request.getParameter("phone"));
            genericDao.saveOrUpdate(user);*/


        userDao.saveOrUpdate(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/searchUser?searchTerm=&searchType=id&submit=viewAll");
        dispatcher.forward(request, response);
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
}
