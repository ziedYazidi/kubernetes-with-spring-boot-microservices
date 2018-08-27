package tn.bd.stage.Catalog.Services;

import tn.bd.stage.Catalog.Entities.Car;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    public List<Car> findAllCars();

    public Car saveCar(Car car);

    public Optional<Car> getcarById(Integer carId);
}
