package anthohugo.laboquiz.domains.entities;

import anthohugo.laboquiz.domains.forms.AnswerForm;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;

//    @Column
//    private Long question_quiz_id;

    @Column(length = 255)
    private String question_text;

    @Column
    private int question_diff;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Answer> answers;

    public Question() {
        this.answers = new HashSet<>();
    }

    public void addAnswer(Answer a){
        a.setQuestion(this);
        answers.add(a);
    }

}