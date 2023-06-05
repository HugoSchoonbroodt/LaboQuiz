package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Question;
import anthohugo.laboquiz.domains.entities.Quiz;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions;

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
