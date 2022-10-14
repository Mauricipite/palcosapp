package com.usa.palcoapp.repository;

import com.usa.palcoapp.model.Reservation;
import com.usa.palcoapp.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAllReservations (){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservationById (Integer id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation saveReservation (Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void deleteReservation (Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
}
