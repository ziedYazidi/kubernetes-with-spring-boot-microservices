package tn.bd.stage.Catalog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bd.stage.Catalog.Entities.Car;
import tn.bd.stage.Catalog.Services.ICarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/findAll" , method = RequestMethod.GET)
    @ResponseBody()
    public List<Car> findAllCars(){
        return carService.findAllCars();
    }

    @RequestMapping(value = "/find/{carId}" , method = RequestMethod.GET)
    @ResponseBody()
    public Optional<Car> getCarById(@PathVariable("carId") Integer carId){
        return carService.getcarById(carId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
}
