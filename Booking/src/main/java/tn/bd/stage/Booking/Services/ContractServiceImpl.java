package tn.bd.stage.Booking.Services;

import org.springframework.stereotype.Service;
import tn.bd.stage.Booking.Entities.Contract;
import tn.bd.stage.Booking.Repositories.ContractRepository;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService{

    private ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

}
