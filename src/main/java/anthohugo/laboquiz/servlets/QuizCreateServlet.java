package anthohugo.laboquiz.servlets;

import anthohugo.laboquiz.domains.forms.AnswerForm;
import anthohugo.laboquiz.domains.forms.QuestionForm;
import anthohugo.laboquiz.domains.forms.QuizForm;
import anthohugo.laboquiz.services.QuizService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name = "quizCreate", urlPatterns = "/quizCreate")
public class QuizCreateServlet extends HttpServlet {

    @Inject
    private QuizService quizService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/quizCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String quizTitle = request.getParameter("quizTitle");
        String quizDescription = request.getParameter("quizDescription");

        QuizForm quizForm = new QuizForm();
        quizForm.setQuiz_title(quizTitle);
        quizForm.setQuiz_desc(quizDescription);

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("question")) {
                String questionText = request.getParameter(paramName);
                int questionIndex = Integer.parseInt(paramName.substring(8));

                QuestionForm questionForm = new QuestionForm();
                questionForm.setQuestion_text(questionText);

                String answerParamPrefix = "answer" + questionIndex + "-";
                String isCorrectParam = "isCorrect" + questionIndex;

                Enumeration<String> answerParamNames = request.getParameterNames();

                while (answerParamNames.hasMoreElements()) {
                    String answerParamName = answerParamNames.nextElement();
                    if (answerParamName.startsWith(answerParamPrefix)) {
                        String answerText = request.getParameter(answerParamName);
                        int answerIndex = Integer.parseInt(answerParamName.substring(answerParamPrefix.length()));

                        AnswerForm answerForm = new AnswerForm();
                        answerForm.setAnswer_text(answerText);
                        answerForm.setIs_correct(answerParamName.equals(isCorrectParam));

                        questionForm.getAnswers().add(answerForm.toEntity());
                    }
                }

                quizForm.getQuestions().add(questionForm.toEntity());
            }
        }
        // Ajouter le quiz avec ses questions et réponses
        quizService.add(quizForm);

        response.sendRedirect(request.getContextPath() + "/");
    }
}