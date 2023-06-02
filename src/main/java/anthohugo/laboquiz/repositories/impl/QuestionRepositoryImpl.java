package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import anthohugo.laboquiz.repositories.QuestionRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class QuestionRepositoryImpl extends BaseRepositoryImpl<Long, Question> implements QuestionRepository, Serializable {

    @Override
    public Question findById(long id) {
        Query query = em.createQuery("SELECT u FROM Question u WHERE u.question_id = :id");
        query.setParameter("question_id", id);
        List<Question> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

}
