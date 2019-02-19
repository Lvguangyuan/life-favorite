package top.grandma.lifefavorite.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class.
@DynamicUpdate // dynamic update specified fields.
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 25)
    private String title;

    private String link;

    private String description;

    @Column(length = 25)
    private String type;

    private String imageId;

    @Column(nullable = false, updatable = false)
    private Date createDate;

    private Date modifiedDate;

}
