package com.example.railway.controller;

import com.example.railway.model.Train;
import com.example.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/add")
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @GetMapping("/availability")
    public List<Train> getTrains(@RequestParam String source, @RequestParam String destination) {
        return trainService.findTrains(source, destination);
    }

    @PostMapping("/update-seats")
    public Train updateSeats(@RequestParam Long id, @RequestParam int seats) {
        return trainService.updateTrainSeats(id, seats);
    }
}
