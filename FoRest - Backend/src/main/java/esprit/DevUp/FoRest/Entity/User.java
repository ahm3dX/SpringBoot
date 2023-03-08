package esprit.DevUp.FoRest.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import esprit.DevUp.FoRest.Entity.TypeUser;
import esprit.DevUp.FoRest.Entity.others.accessRestaurant;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private int id_user;
    private String firstname;
    private String Lastname;
    private String Email;
    private String Password;
    private int phone_number;
    private String gender;
    private int CIN;

    private Date DateNaissance;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;


    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "user")
    @JsonIgnore
    private Set<Event> event;


    @OneToMany(mappedBy = "usersP")
    @JsonIgnore
    private Set<participant> participants;
}

