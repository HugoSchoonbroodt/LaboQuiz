package anthohugo.laboquiz.servlets;

import anthohugo.laboquiz.domains.dtos.QuizDTO;
import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.services.QuizService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "quizUtil", urlPatterns = "/quizUtil")
public class QuizUtilServlet extends HttpServlet {

    @Inject
    private QuizService quizService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizIdParam = request.getParameter("quiz_id");
        if (quizIdParam != null) {
            Long quizId = Long.parseLong(quizIdParam);
            QuizDTO quizDTO = quizService.getQuizById(quizId);
            request.setAttribute("quiz", quizDTO);
            request.getRequestDispatcher("/WEB-INF/pages/quizUtil.jsp").forward(request, response);
        } else {
            List<QuizDTO> quizzes = quizService.getAll();
            request.setAttribute("quizzes", quizzes);
            request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
