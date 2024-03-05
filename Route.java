package com.RailwayManagementSystem;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "source_station")
    private String sourceStation;

    @Column(name = "destination_station")
    private String destinationStation;

    @Column(name = "distance")
    private double distance;

    @Column(name = "travel_time")
    private String travelTime;

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train2) {
		this.train = train2;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}


}