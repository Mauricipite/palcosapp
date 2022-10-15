package com.usa.palcoapp.servicio;

import com.usa.palcoapp.model.ClientReport;
import com.usa.palcoapp.model.Reservation;
import com.usa.palcoapp.model.ReservationReport;
import com.usa.palcoapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<Reservation> getReservation(Integer id) {return reservationRepository.getReservationById(id);}

    public Reservation saveReservation (Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> optional = reservationRepository.getReservationById(reservation.getIdReservation());
            if (optional.isEmpty()) {
                return reservationRepository.saveReservation(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation updateReservation (Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> optional = reservationRepository.getReservationById(reservation.getIdReservation());
            if (!optional.isEmpty()) {
                if (reservation.getStartDate() != null){
                    optional.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null){
                    optional.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStartDate() != null){
                    optional.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getStatus() != null){
                    optional.get().setStatus(reservation.getStatus());
                }
                reservationRepository.saveReservation(optional.get());
                return optional.get();
            } else {
                return reservation;
            }
        }else {
            return reservation;
        }
    }

    public boolean deleteReservation (Integer id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.deleteReservation(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ReservationReport getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }

    public List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
    }



}
