package TN.CompanyManagement.Entity.Forum;

import TN.CompanyManagement.Entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid", nullable = false)
    private Integer idComment;
    @Column
    private String content;
    @Column
    private Integer upvotes=0;
    @Column
    private Integer downvote=0;
    @Transient
    boolean gotFlagged=false;
    @Column
    @Nullable
    private Date CommentedAt=new Date();


   // @ManyToOne(fetch = FetchType.LAZY)
   @ManyToOne(fetch = FetchType.EAGER,targetEntity = Post.class)
   @JoinColumn(name = "parentpost_postid")

   Post parentpost;

    public Post getParentpost() {
        return parentpost;
    }

    public void setParentpost(Post parentpost) {
        this.parentpost = parentpost;
    }
    //  @ManyToOne
   // Comment Replyof;

    @ManyToOne
    User owner;

    public Integer getscore() {
        return upvotes-downvote;
    }
}
