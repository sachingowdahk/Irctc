package com.example.railway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long trainId;
    private Long userId;
    private int seatsBooked;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	

    // Getters and setters
}
