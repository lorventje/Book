package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer review_id;
    @Column(unique = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Reviewer reviewer;

}
