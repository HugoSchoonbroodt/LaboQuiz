package anthohugo.laboquiz.domains.dtos;

import anthohugo.laboquiz.domains.entities.Quiz;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class QuizDTO {

    private long id;

    private String quiz_title;

    private String quiz_desc;

    public QuizDTO(String quizTitle, String quizDesc) {
        this.quiz_title = quizTitle;
        this.quiz_desc = quizDesc;
    }

    public static QuizDTO fromEntity(Quiz a){
        return new QuizDTO().builder()
                .id(a.getQuiz_id())
                .quiz_title(a.getQuiz_title())
                .quiz_desc(a.getQuiz_desc())
                .build();
    }
}