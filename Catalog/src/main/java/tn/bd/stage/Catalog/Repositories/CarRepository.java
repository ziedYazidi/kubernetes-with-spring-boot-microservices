package tn.bd.stage.Catalog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.bd.stage.Catalog.Entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
