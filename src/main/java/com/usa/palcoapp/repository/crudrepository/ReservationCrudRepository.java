package com.usa.palcoapp.repository.crudrepository;

import com.usa.palcoapp.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
