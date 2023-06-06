package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class QuizForm {

    @NotBlank(message = "Required Field")
    @Size(max = 255, message = "Max size set to 255")
    private String quiz_title;

    @NotBlank(message = "Required Field")
    @Size(max = 255, message = "Max size set to 255")
    private String quiz_desc;

    private Set<QuestionForm> questions;

    public QuizForm() {
        this.questions = new HashSet<>();
    }

    public Quiz toEntity() {
        Quiz quiz = new Quiz(quiz_title, quiz_desc);

        if (questions != null) {
            for (QuestionForm questionForm : questions) {
                quiz.addQuestion(questionForm.toEntity());
            }
        }
        return quiz;
    }

    public void addQuestion(QuestionForm questionForm) {
        if (questions == null) {
            questions = new HashSet<>();
        }
        questions.add(questionForm);
    }

    public Set<QuestionForm> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionForm> questions) {
        if (this.questions == null) {
            this.questions = new HashSet<>();
        }
        this.questions.addAll(questions);
    }
}
