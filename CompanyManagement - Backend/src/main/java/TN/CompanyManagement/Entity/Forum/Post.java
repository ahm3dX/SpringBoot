package TN.CompanyManagement.Entity.Forum;

import TN.CompanyManagement.Entity.User;
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
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "postid", nullable = false)
        private Integer idPost;
        private String question;
        //private PostType postType;
       // private String tags;
        private Integer upvotes=0;
        private Integer downvote=0;
        private Integer nbFlaged=0;
        @Enumerated
        private PostStatus postStatus=PostStatus.Open;
        private Date CreatedAt=new Date();


        @ManyToOne(fetch = FetchType.EAGER)
        User owner;
       /* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        List<Comment> comment ;//= new ArrayList<Comment>();

        public Collection<Comment> getComment() {
                return comment;
        }

        public void setComment(Collection<Comment> comment) {
                this.comment = (List<Comment>) comment;
        }*/

        public Integer getscore() {
                return upvotes-downvote;
        }
}



