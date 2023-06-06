package anthohugo.laboquiz.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quiz_id;

    @Column(length = 255)
    private String quiz_title;

    @Column(length = 255)
    private String quiz_desc;

    @Column
    private int quiz_diff;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Question> questions;

    public Quiz(String quiz_title, String quiz_desc) {
        this();
        this.quiz_title = quiz_title;
        this.quiz_desc = quiz_desc;
    }

    public Quiz() {
        this.questions = new HashSet<>();
    }

    public void addQuestion(Question q){
        q.setQuiz(this);
        questions.add(q);
    }
}