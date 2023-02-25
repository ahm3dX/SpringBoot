package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.others.ReservationPlace;

import java.util.List;

public interface IServiceReservationPlace {
    List<ReservationPlace> retrieveAllReservationPlace();

    ReservationPlace addReservationPlace (ReservationPlace u);

    ReservationPlace updateReservationPlace (ReservationPlace u);

    ReservationPlace retrieveReservationPlace(Integer idReservationPlace);

    void removeReservationPlace(Integer idReservationPlace);
}
