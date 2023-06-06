package anthohugo.laboquiz.services.impl;

import anthohugo.laboquiz.domains.dtos.QuizDTO;
import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import anthohugo.laboquiz.domains.forms.QuizForm;
import anthohugo.laboquiz.repositories.QuestionRepository;
import anthohugo.laboquiz.repositories.QuizRepository;
import anthohugo.laboquiz.services.QuizService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static anthohugo.laboquiz.domains.dtos.QuizDTO.fromEntity;

@Named
@SessionScoped
public class QuizServiceImpl implements QuizService,Serializable {

    @Inject
    private QuizRepository quizRepository;

    @Inject
    private QuestionRepository questionRepository;

//    private AnswerRepository answerRepository;

    @Override
    public void add(Quiz a) {
        quizRepository.add(a);
    }

    @Override
    public Optional<QuizDTO> getOne(Long id) {
        Optional<Quiz> quiz = quizRepository.getOne(Quiz.class, id);
        return quiz.map(QuizDTO::fromEntity);
    }

    @Override
    public List<QuizDTO> getAll() {
        List<QuizDTO> quizDTOS = new ArrayList<>();
        List<Quiz> quizzes = quizRepository.getAll(Quiz.class);

        for (Quiz quiz : quizzes) {
            QuizDTO quizDTO = fromEntity(quiz);
            quizDTOS.add(quizDTO);
        }

        return quizDTOS;
    }

    @Override
    public void update(Long id) {
        Optional<Quiz> quizToUpdateOptional = quizRepository.getOne(Quiz.class, id);
        if (quizToUpdateOptional.isPresent()) {
            Quiz quizToUpdate = quizToUpdateOptional.get();

            quizRepository.update(Quiz.class, id, quizToUpdate);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Quiz> quizToDeleteOptional = quizRepository.getOne(Quiz.class, id);
        if (quizToDeleteOptional.isPresent()) {
            Quiz quizToDelete = quizToDeleteOptional.get();
            quizRepository.delete(Quiz.class, id);
        }
    }

    @Override
    public QuizDTO getQuizById(Long quizId) {
        Quiz target = quizRepository.findById(quizId);

        return fromEntity(target);
    }

    @Override
    public Set<Question> getQuestionsByQuizId(Long quizId) {
        Quiz target = quizRepository.findById(quizId);

        return target.getQuestions();
    }

    @Override
    public Set<Answer> getAnswersByQuestionId(Long questionId) {
        Question target = questionRepository.findById(questionId);

        return target.getAnswers();
    }

    @Override
    public void addQuestions(Quiz q, Question a) {
        q.addQuestion(a);
    }
    
    @Override
    public void addAnswers(Question q, Answer a) {
        q.addAnswer(a);
    }

}
