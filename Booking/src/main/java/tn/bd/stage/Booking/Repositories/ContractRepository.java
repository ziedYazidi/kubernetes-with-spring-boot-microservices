package tn.bd.stage.Booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bd.stage.Booking.Entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
