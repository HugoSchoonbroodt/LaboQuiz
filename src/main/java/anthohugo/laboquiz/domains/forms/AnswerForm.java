package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.Answer;
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

    public boolean getIs_correct(){
        return is_correct;
    }

    public void setIs_correct(boolean is_correct){
        this.is_correct = is_correct;
    }

    public Answer toEntity(){

        return Answer.builder()
                .answer_text(getAnswer_text())
                .is_correct(getIs_correct())
                .build();
    }
}
