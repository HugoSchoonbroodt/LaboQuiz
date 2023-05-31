package anthohugo.laboquiz.services;

import anthohugo.laboquiz.domains.dtos.QuestionDTO;
import anthohugo.laboquiz.domains.dtos.QuizDTO;
import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.forms.QuizForm;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionService {

    void add(QuizForm a);

    Optional<QuestionDTO> getOne(Long id);

    List<QuestionDTO> getAll();

    void update(Long id);

    void delete(Long id);

    Set<Answer> getAnswersByQuestionId(Long questionId);
}
