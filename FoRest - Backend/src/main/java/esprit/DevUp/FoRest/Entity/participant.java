package esprit.DevUp.FoRest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import esprit.DevUp.FoRest.Entity.others.accessRestaurant;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
