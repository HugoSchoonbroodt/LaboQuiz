package anthohugo.laboquiz.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
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

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.PERSIST)
    private Set<Question> questions;

}