package esprit.DevUp.FoRest.Entity.Event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import esprit.DevUp.FoRest.Entity.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "participant")
public class participant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @ManyToOne
    @JsonIgnore
    Event event;

    @ManyToOne
    @JsonIgnore
    private User usersP;


    /*
    @OneToMany(mappedBy = "offreRestaurant")
    private List<accessRestaurant> accessRestaurants;

    @ManyToOne
    @JsonIgnore
    Restaurant restaurant;*/
}
