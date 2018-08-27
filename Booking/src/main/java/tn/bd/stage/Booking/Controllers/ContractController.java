package tn.bd.stage.Booking.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.bd.stage.Booking.Entities.Contract;
import tn.bd.stage.Booking.Services.IContractService;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private IContractService contractService;

    public ContractController(IContractService contractService) {
        this.contractService = contractService;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody()
    public List<Contract> findAllContracts(){
        return contractService.findAllContracts();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody()
    public Contract saveContract(@RequestBody Contract contract){
        return contractService.saveContract(contract);
    }
}
