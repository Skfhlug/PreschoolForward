package edu.preschool.controller;

import edu.preschool.entity.Parent;
import edu.preschool.persitence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/deleteParentStudentRelationship"}
)
public class DeleteParentStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao parentDao = new GenericDao(Parent.class);

        Parent parent = new Parent();
        parentDao.delete(parentDao.getById(Integer.parseInt(req.getParameter("deleteID"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchParent?searchTerm=&searchType=id&submit=viewAll");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
