package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.domains.entities.Quiz;
import anthohugo.laboquiz.repositories.QuizRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class QuizRepositoryImpl extends BaseRepositoryImpl<Long, Quiz> implements QuizRepository, Serializable {

    @Override
    public Quiz findById(long id) {
        return null;
    }

}