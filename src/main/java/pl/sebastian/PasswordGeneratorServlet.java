package pl.sebastian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.sebastian.PasswordGenerator.generatePassword;

@WebServlet("/generator")
public class PasswordGeneratorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer passwordLength = Integer.valueOf(req.getParameter("password_length"));
        boolean includeSymbols = "on".equals(req.getParameter("include_symbols"));
        boolean includeNumbers = "on".equals(req.getParameter("include_numbers"));
        boolean includeLowercase = "on".equals(req.getParameter("include_lowercase_characters"));
        boolean includeUppercase = "on".equals(req.getParameter("include_uppercase_characters"));

        String password = generatePassword(passwordLength, includeSymbols, includeNumbers, includeLowercase, includeUppercase);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Your password: " + password);

    }
}
