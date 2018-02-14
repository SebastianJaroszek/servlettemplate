package pl.sebastian;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Processing form...");
    }

    private void process(HttpServletRequest req, HttpServletResponse resp, String message) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(message);

        Enumeration<String> parameters = req.getParameterNames();

        out.print("<ul>");

        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            String value = req.getParameter(parameter);
            out.println("<li>" + value + "</li>");
        }

        out.println("</ul>");
    }

}
