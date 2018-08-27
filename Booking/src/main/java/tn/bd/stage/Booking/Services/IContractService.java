package tn.bd.stage.Booking.Services;

import tn.bd.stage.Booking.Entities.Contract;

import java.util.List;

public interface IContractService {

    public List<Contract> findAllContracts();

    public Contract saveContract(Contract contract);
}
