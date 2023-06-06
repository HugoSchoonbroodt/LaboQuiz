package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Answer;
import anthohugo.laboquiz.domains.entities.Question;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AnswerForm {

    @NotBlank(message = "Required Field")
    @Size(max = 255, message = "Max size set to 255")
    private String answer_text;

    private boolean is_correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionForm question;


    public Answer toEntity() {
        Answer answer = new Answer();
        answer.setAnswer_text(getAnswer_text());
        answer.set_correct(is_correct);
        answer.setQuestion(question != null ? question.toEntity() : null);
        return answer;
    }
}
