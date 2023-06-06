package anthohugo.laboquiz.servlets;

import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
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
import java.util.Arrays;
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

        if (quizTitle != null && quizDescription != null) {
            QuizForm quizForm = new QuizForm();
            quizForm.setQuiz_title(quizTitle);
            quizForm.setQuiz_desc(quizDescription);

            Quiz quiz = quizForm.toEntity();

            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String[] responses = request.getParameterValues("isCorrect-" + paramName);
                if (paramName.startsWith("question")) {
                    String questionText = request.getParameter(paramName);

                    Question question = new Question();
                    question.setQuestion_text(questionText);
                    question.setQuiz(quiz);

                    Enumeration<String> answerParamNames = request.getParameterNames();
                    while (answerParamNames.hasMoreElements()) {
                        String answerParamName = answerParamNames.nextElement();
                        if (answerParamName.startsWith("answer-" + paramName)) {
                            String answerText = request.getParameter(answerParamName);
                            boolean isCorrect = Arrays.asList(responses).contains(answerParamName);

                            Answer answer = new Answer();
                            answer.setAnswer_text(answerText);
                            answer.set_correct(isCorrect);

                            question.addAnswer(answer);
                        }
                    }

                    quiz.addQuestion(question);
                }
            }

            quizService.add(quiz);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }
}
