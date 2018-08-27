package tn.bd.stage.Booking.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractId;

    @NotNull
    private Integer carId;

    @NotNull
    private LocalDateTime contractDate;

    @NotNull
    private String userFirstName;

    @NotNull
    private String userLastName;

    @NotNull
    private String userEmail;

    @NotNull
    private Long userPhoneNumber;

    @NotNull
    private LocalDateTime pickUpDate;

    @NotNull
    private LocalDateTime dropDate;

    private String pickUpPlace;

    private String dropPlace;

    public Contract() {
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public LocalDateTime getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDateTime contractDate) {
        this.contractDate = contractDate;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDateTime getDropDate() {
        return dropDate;
    }

    public void setDropDate(LocalDateTime dropDate) {
        this.dropDate = dropDate;
    }

    public String getPickUpPlace() {
        return pickUpPlace;
    }

    public void setPickUpPlace(String pickUpPlace) {
        this.pickUpPlace = pickUpPlace;
    }

    public String getDropPlace() {
        return dropPlace;
    }

    public void setDropPlace(String dropPlace) {
        this.dropPlace = dropPlace;
    }
}
