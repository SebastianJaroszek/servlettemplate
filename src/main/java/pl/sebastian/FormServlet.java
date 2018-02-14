package pl.sebastian;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/processform")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String acceptTerms = req.getParameter("accept");
        String sex = req.getParameter("sex");
        String hardware = req.getParameter("device");

        if (acceptTerms == null || sex == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("form.html");
            requestDispatcher.forward(req, resp);
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome " + username + "</h1>");
        out.println("Your sex: " + sex + "<br>Your gaming platform: " + hardware);

    }

}
