package esprit.DevUp.FoRest.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private Integer userid;
    private String firstname;
    private String Lastname;
    private String userName;
    private String Email;
    private String Password;
    private int phone_number;
    private String gender;
    private int CIN;
    private Date DateNaissance;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;



    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "user")
    @JsonIgnore
    private Set<Event> event;

    @OneToMany(mappedBy = "usersP")
    @JsonIgnore
    private Set<participant> participants;
}
