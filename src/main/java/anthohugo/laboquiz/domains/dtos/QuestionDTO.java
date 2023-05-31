package anthohugo.laboquiz.domains.dtos;

import anthohugo.laboquiz.domains.entities.Question;
import lombok.*;

import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class QuestionDTO {

    private String question_text;

    private Set<AnswerDTO> answerDTOS;

    public static QuestionDTO fromEntity(Question a){

        return new QuestionDTO().builder()
                .question_text(a.getQuestion_text())
                .answerDTOS(AnswerDTO.fromEntity(a.getAnswers()))
                .build();
    }
}