package anthohugo.laboquiz.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "answers")
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

//    @Column
//    private Long answer_question_id;

    @Column(length = 255)
    private String answer_text;

    @Column
    private boolean is_correct;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public void setQuestion(Question question) {
        this.question = question;
    }

}