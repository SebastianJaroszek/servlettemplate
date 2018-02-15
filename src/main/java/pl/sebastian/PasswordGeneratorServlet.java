package pl.sebastian;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.sebastian.PasswordGenerator.generatePassword;

@WebServlet("/generator")
public class PasswordGeneratorServlet extends HttpServlet {

    private static final String ON = "on";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer passwordLength = Integer.valueOf(req.getParameter("password_length"));
        boolean includeSymbols = ON.equals(req.getParameter("include_symbols"));
        boolean includeNumbers = ON.equals(req.getParameter("include_numbers"));
        boolean includeLowercase = ON.equals(req.getParameter("include_lowercase_characters"));
        boolean includeUppercase = ON.equals(req.getParameter("include_uppercase_characters"));

        String password = generatePassword(passwordLength, includeSymbols, includeNumbers,
                includeLowercase, includeUppercase);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Your password: " + password);

    }
}
