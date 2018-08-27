package tn.bd.stage.Catalog.Entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer carId;
    private String carName;
    private String carImmatriculation;
    private String carImage;
    private Integer carPrice;
    private Integer carNbrSeats;
    private Integer carNbrDoors;
    private boolean containsAC;
    private boolean isManual;

    public Car() {
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarImmatriculation() {
        return carImmatriculation;
    }

    public void setCarImmatriculation(String carImmatriculation) {
        this.carImmatriculation = carImmatriculation;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    public Integer getCarNbrSeats() {
        return carNbrSeats;
    }

    public void setCarNbrSeats(Integer carNbrSeats) {
        this.carNbrSeats = carNbrSeats;
    }

    public Integer getCarNbrDoors() {
        return carNbrDoors;
    }

    public void setCarNbrDoors(Integer carNbrDoors) {
        this.carNbrDoors = carNbrDoors;
    }

    public boolean isContainsAC() {
        return containsAC;
    }

    public void setContainsAC(boolean containsAC) {
        this.containsAC = containsAC;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }
}