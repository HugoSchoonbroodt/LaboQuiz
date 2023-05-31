package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.repositories.AnswerRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class AnswerRepositoryImpl extends BaseRepositoryImpl<Long, Answer> implements AnswerRepository, Serializable {

}
