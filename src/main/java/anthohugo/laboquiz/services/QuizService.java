package anthohugo.laboquiz.services;

import anthohugo.laboquiz.domains.dtos.QuizDTO;
import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import anthohugo.laboquiz.domains.forms.QuizForm;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuizService {

    void add(Quiz a);

    Optional<QuizDTO> getOne(Long id);

    List<QuizDTO> getAll();

    void update(Long id);

    void delete(Long id);

    QuizDTO getQuizById(Long quizId);

    Set<Question> getQuestionsByQuizId(Long quizId);

    Set<Answer> getAnswersByQuestionId(Long questionId);

    public void addAnswers(Question q, Answer a);

    void addQuestions(Quiz q, Question a);
}
