package tn.iit.micro.service.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.micro.service.cloud.dto.AddressRequest;
import tn.iit.micro.service.cloud.dto.AddressResponse;
import tn.iit.micro.service.cloud.entities.Address;
import tn.iit.micro.service.cloud.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.createAddress(addressRequest);
    }
    @GetMapping("/test")
    public String test() {
        return "Address service is working!";
    }
  
    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        if (addresses.isEmpty()) {
            return ResponseEntity.noContent().build();  // Si la liste est vide, on retourne un statut 204
        }
        return ResponseEntity.ok(addresses);  // Sinon, on retourne la liste avec un statut 200
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id) {
        return addressService.getById(id);
    }
    @GetMapping("/")
    public String getBaseApi() {
        // Par exemple, retour d'un message ou d'une donnée générale
        return "API Address Service is running";
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }

}