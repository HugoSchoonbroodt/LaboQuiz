package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.domains.entities.Quiz;
import anthohugo.laboquiz.repositories.QuizRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class QuizRepositoryImpl extends BaseRepositoryImpl<Long, Quiz> implements QuizRepository, Serializable {

    @Override
    public Quiz findById(long id) {
        Query query = em.createQuery("SELECT u FROM Quiz u WHERE u.quiz_id = :id");
        query.setParameter("quiz_id", id);
        List<Quiz> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

}