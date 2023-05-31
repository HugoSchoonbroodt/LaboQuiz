package anthohugo.laboquiz.servlets;

import anthohugo.laboquiz.domains.dtos.UserDTO;
import anthohugo.laboquiz.domains.dtos.UserLoginForm;
import anthohugo.laboquiz.exceptions.EntityNotFoundException;
import anthohugo.laboquiz.exceptions.InvalidPasswordUserException;
import anthohugo.laboquiz.services.UserService;
import anthohugo.laboquiz.services.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("username", "");
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserLoginForm userForm = new UserLoginForm(username, password);

        try {
            UserDTO userDTO = userService.authenticate(userForm);
            request.getSession().setAttribute("connectedUser", userDTO);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (EntityNotFoundException e) {
            request.setAttribute("errorMessage", "Invalid username");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } catch (InvalidPasswordUserException e) {
            request.setAttribute("errorMessage", "Invalid password");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("errorMessage", "Error. Try again.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}