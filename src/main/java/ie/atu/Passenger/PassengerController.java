package ie.atu.Passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/passenger")
public class PassengerController {

    PassengerService myService;

    public PassengerController(PassengerService myService) {
        this.myService = myService;
    }

    @GetMapping
    public List<Passenger> getPassengers()
    {
        return myService.getPassengers();
    }

    @GetMapping("/{passengerID}")
    public Passenger getPassenger(@PathVariable String passengerID)
    {

        return myService.getPassenger(passengerID);

    }

    //Save Operation
    @PostMapping("")
    public void savePassenger(@RequestBody Passenger passenger){
        myService.savePassenger(passenger);
    }

    //Find Passenger by Name
    @GetMapping("/name/{name}")
    public Passenger getPassengerName(@PathVariable("name") String name){
        return myService.findPassengerByName(name);
    }

    //Delete operation
    @DeleteMapping("/delete/{count}")
    public void deletePassenger(@PathVariable("count") Long count){
        myService.deletePassenger(count);
    }

    //http://localhost:8081/api/passenger/age?age_start=1&age_end=60
    @GetMapping("/age")
    public List<Passenger> getPassengersByAge(@RequestParam(name = "age_start") int age1, @RequestParam(name = "age_end") int age2){
        return myService.findPassengerByAgeRange(age1, age2);
    }


}
