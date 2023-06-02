package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.entities.Question;
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
public class QuestionForm {

    @NotBlank(message = "Required Field")
    @Size(max = 255, message = "Max size set to 255")
    private String question_text;

    private Set<Answer> answers;

    public QuestionForm() {
        this.answers = new HashSet<>();
    }

    public Question toEntity(){

        return Question.builder()
                .question_text(getQuestion_text())
                .answers(getAnswers())
                .build();
    }
}
