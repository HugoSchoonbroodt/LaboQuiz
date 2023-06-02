package anthohugo.laboquiz.repositories;

import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;

public interface QuestionRepository extends BaseRepository<Long, Question> {

    Question findById(long id);
}