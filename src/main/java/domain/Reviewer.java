package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Reviewer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewer_id;
    @Column(unique = false)
    private String name;
    private String email;

    @OneToMany(mappedBy = "reviewer")
    private List<Review> reviews;
}
