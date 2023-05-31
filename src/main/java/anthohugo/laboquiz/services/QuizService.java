package anthohugo.laboquiz.services;

import anthohugo.laboquiz.domains.dtos.QuizDTO;
import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.forms.QuizForm;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuizService {

    void add(QuizForm a);

    Optional<QuizDTO> getOne(Long id);

    List<QuizDTO> getAll();

    void update(Long id);

    void delete(Long id);

    QuizDTO getQuizById(Long quizId);

    Set<Question> getQuestionsByQuizId(Long quizId);
}
