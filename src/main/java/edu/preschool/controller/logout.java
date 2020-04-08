
package edu.preschool.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Logout.
 * @author Jeanne
 * @version  1.0
 * @since 2020-03-02
 */
@WebServlet(
        name = "logoutServlet", urlPatterns = {"/logout"}
        )
public class logout extends HttpServlet{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
        response.sendRedirect("/index.jsp");
    }
}