package edu.preschool.controller;
import edu.preschool.entity.Student;
import edu.preschool.entity.User;
import edu.preschool.persitence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        name = "searchStudent",
        urlPatterns = { "/searchStudent" }
)
public class SearchStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  searchTerm = req.getParameter("searchTerm" );
        String  searchType = req.getParameter("searchType" );

        GenericDao genericDao = new GenericDao(Student.class);

        if (searchTerm.length()>0) {
            req.setAttribute("resultList", genericDao.getByPropertyLike(searchType, searchTerm));
        } else {
            req.setAttribute("students", genericDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/student.jsp");
        dispatcher.forward(req, resp);
    }
}
