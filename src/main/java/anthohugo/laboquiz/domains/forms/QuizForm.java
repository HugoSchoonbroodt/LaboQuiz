package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @Builder @AllArgsConstructor @ToString
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

    public Quiz toEntity(){

        return Quiz.builder()
                .quiz_title(getQuiz_title())
                .quiz_desc(getQuiz_desc())
                .questions(getQuestions())
                .build();
    }
}