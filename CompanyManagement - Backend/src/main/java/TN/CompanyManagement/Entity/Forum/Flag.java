package TN.CompanyManagement.Entity.Forum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name="Flag")
public class Flag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flagid", nullable = false)
    private Integer idFlag;
    @Column(name = "AutoFlag")
    private boolean autoFlag=false;
    @ManyToOne
    @JoinColumn(name = "post_postid")
    Post post;
    @ManyToOne
    @JoinColumn(name = "comment_commentid")
    Comment comment;
    @Enumerated
    Reasons reasonType;
    private Date flaggedAt=new Date();

}
