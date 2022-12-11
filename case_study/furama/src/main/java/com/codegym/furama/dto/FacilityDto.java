package com.codegym.furama.dto;

import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDto implements Validator {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherCovenience;
    private double pollArea;
    private int numberOfFloors;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherCovenience, double pollArea, int numberOfFloors, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherCovenience = descriptionOtherCovenience;
        this.pollArea = pollArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherCovenience() {
        return descriptionOtherCovenience;
    }

    public void setDescriptionOtherCovenience(String descriptionOtherCovenience) {
        this.descriptionOtherCovenience = descriptionOtherCovenience;
    }

    public double getPollArea() {
        return pollArea;
    }

    public void setPollArea(double pollArea) {
        this.pollArea = pollArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
