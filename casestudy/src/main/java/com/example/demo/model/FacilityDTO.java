package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

public class FacilityDTO implements Validator {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    private String facilityFree;
    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id")
    private FacilityType facilityType;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;
    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    public FacilityDTO() {
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

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
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

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
        if(!facilityDTO.name.matches("^[A-Z][a-z]*(?: [A-Z][a-z]*)*$")){
            errors.rejectValue("name","","Tên k được chứa số ,các kí tự đầu tiên của mỗi từ phải viết hoa và có từ 5 đến 50 kí tự");
        }
        if(facilityDTO.area<0){
            errors.rejectValue("area","","Diện tích phải lớn hơn 0");
        }
        if((facilityDTO.cost<1)){
            errors.rejectValue("cost","","Giá phải là số dương");
        }
        if(facilityDTO.maxPeople<1){
            errors.rejectValue("maxPeople","","Số người tối đa phải là số nguyên dương");
        }
        switch (facilityDTO.facilityType.getId()){
            case 1:
            case 2:
                if(facilityDTO.numberOfFloors<0){
                    errors.rejectValue("numberOfFloors","","Số tầng phải là số nguyên dương");
                }
                break;
            case 3:
                break;
        }
    }
}
