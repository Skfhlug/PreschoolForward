
package edu.preschool.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The type Logout.
 * @author Suparin
 * @version  1.0
 * @since 2020-03-02
 */
@WebServlet(
    urlPatterns = {"/logout"}
    )
public class logout extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.getSession().invalidate();


        response.sendRedirect(request.getContextPath() + "/PreschoolForward/index.jsp");
    }
}