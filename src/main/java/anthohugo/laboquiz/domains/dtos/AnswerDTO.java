package anthohugo.laboquiz.domains.dtos;

import anthohugo.laboquiz.domains.entities.Answer;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class AnswerDTO {

    private String answer_text;

    private boolean is_correct;

    public static Set<AnswerDTO> fromEntity(Set<Answer> answers){
        Set<AnswerDTO> result = new HashSet<>();
        for (Answer a : answers){
            result.add(fromEntity(a));
        }
        return result;

//        return answers.stream().map(AnswerDTO::fromEntity).collect(Collectors.toSet());
    }

    public static AnswerDTO fromEntity(Answer a){

        return AnswerDTO.builder()
                .answer_text(a.getAnswer_text())
                .is_correct(a.is_correct())
                .build();
    }
}