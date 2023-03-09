package esprit.DevUp.FoRest.Entity.Restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TableRestaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_table_restaurant", nullable = false)
    private Integer idTableRestaurant;
    private int number;
    private String block;
    private int now;
    private int max ;

    @ManyToOne
    private Restaurant resto;

    @OneToMany(mappedBy = "table")
    @JsonIgnore
    private List<ReservationPlace> reservationPlaces;
}
