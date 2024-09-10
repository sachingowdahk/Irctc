package com.example.railway.controller;

import com.example.railway.model.Booking;
import com.example.railway.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public Booking bookSeat(@RequestParam Long trainId, @RequestParam Long userId, @RequestParam int seats) {
        return bookingService.bookSeat(trainId, userId, seats);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/{trainId}/user/{userId}")
    public Booking getBooking(@PathVariable Long trainId, @PathVariable Long userId) {
        return bookingService.getBooking(trainId, userId);
    }
}
