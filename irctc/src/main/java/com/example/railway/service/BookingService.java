package com.example.railway.service;

import com.example.railway.model.Booking;
import com.example.railway.model.Train;
import com.example.railway.repository.BookingRepository;
import com.example.railway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Transactional
    public Booking bookSeat(Long trainId, Long userId, int seats) {
        Train train = trainRepository.findById(trainId).orElseThrow();
        if (train.getAvailableSeats() < seats) {
            throw new RuntimeException("Not enough seats available");
        }

        train.setAvailableSeats(train.getAvailableSeats() - seats);
        trainRepository.save(train);

        Booking booking = new Booking();
        booking.setTrainId(trainId);
        booking.setUserId(userId);
        booking.setSeatsBooked(seats);

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking getBooking(Long trainId, Long userId) {
        return bookingRepository.findByTrainIdAndUserId(trainId, userId);
    }
}
