package edu.preschool.controller;


import edu.preschool.entity.User;
import edu.preschool.persitence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        urlPatterns = {"/editUserServlet"}
)
public class editUserServlet extends HttpServlet {
    private GenericDao genericDao;
    @Override
    public void init() throws ServletException {
        genericDao = new GenericDao(User.class);

    }
}
