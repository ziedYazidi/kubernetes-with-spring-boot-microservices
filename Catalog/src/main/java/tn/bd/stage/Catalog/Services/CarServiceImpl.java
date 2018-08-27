package tn.bd.stage.Catalog.Services;

import org.springframework.stereotype.Service;
import tn.bd.stage.Catalog.Entities.Car;
import tn.bd.stage.Catalog.Repositories.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        return  carRepository.save(car);
    }

    @Override
    public Optional<Car> getcarById(Integer carId) {
        return carRepository.findById(carId);
    }
}
