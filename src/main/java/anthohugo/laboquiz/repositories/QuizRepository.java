package anthohugo.laboquiz.repositories;

import anthohugo.laboquiz.domains.entities.Quiz;

public interface QuizRepository extends BaseRepository<Long, Quiz> {

    Quiz findById(long id);
}