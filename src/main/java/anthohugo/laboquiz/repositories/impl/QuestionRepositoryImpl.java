package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.repositories.QuestionRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class QuestionRepositoryImpl extends BaseRepositoryImpl<Long, Question> implements QuestionRepository, Serializable {

}
