package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class QuestionForm {

    @NotBlank(message = "Required Field")
    @Size(max = 255, message = "Max size set to 255")
    private String question_text;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AnswerForm> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizForm quiz;

    public QuestionForm() {
        this.answers = new HashSet<>();
    }

    public Question toEntity() {
        Question question = new Question();
        question.setQuestion_text(getQuestion_text());
        question.setQuiz(quiz != null ? quiz.toEntity() : null);
        // Set the answers for the question
        question.setAnswers(answers.stream().map(AnswerForm::toEntity).collect(Collectors.toSet()));
        return question;
    }

    public void setQuiz(QuizForm quizForm) {
        this.quiz = quizForm;
    }

    public void setAnswers(Set<AnswerForm> answers) {
        this.answers = answers;
    }

    public void addAnswer(AnswerForm answerForm) {
        answerForm.setQuestion(this);
        answers.add(answerForm);
    }
}
