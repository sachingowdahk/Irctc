package com.example.railway.service;

import com.example.railway.model.Train;
import com.example.railway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> findTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    public Train updateTrainSeats(Long id, int seats) {
        Train train = trainRepository.findById(id).orElseThrow();
        train.setAvailableSeats(seats);
        return trainRepository.save(train);
    }
}
