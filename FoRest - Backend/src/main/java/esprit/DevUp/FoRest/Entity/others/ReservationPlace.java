package esprit.DevUp.FoRest.Entity.others;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReservationPlace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation_place", nullable = false)
    private Integer idReservationPlace;
    @ManyToOne
    Restaurant _Restaurant;
    @ManyToOne
    TableRestaurant tableRestaurant;
    @ManyToOne
    Menu menu;
}
