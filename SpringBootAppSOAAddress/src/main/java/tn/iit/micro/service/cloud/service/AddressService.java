package tn.iit.micro.service.cloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.iit.micro.service.cloud.dto.AddressRequest;
import tn.iit.micro.service.cloud.dto.AddressResponse;
import tn.iit.micro.service.cloud.entities.Address;
import tn.iit.micro.service.cloud.repository.AddressRepository;
import tn.iit.micro.service.cloud.utils.AdressNotFoundException;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepo;

    // Méthode pour créer une nouvelle adresse
    public AddressResponse createAddress(AddressRequest addressRequest) {
        // Créez et enregistrez l'adresse
        Address address = new Address(0, addressRequest.getCity(), addressRequest.getStreet());
        address = addressRepo.save(address);
        return new AddressResponse(address);
    }

    // Méthode pour récupérer une adresse par son ID
    public AddressResponse getById(@PathVariable long id) {
        Optional<Address> addressOpt = addressRepo.findById(id);
        if (addressOpt.isPresent()) {
            return new AddressResponse(addressOpt.get());
        } else {
            // Gestion de l'absence de l'adresse, par exemple, renvoyer une erreur ou null
            throw new AdressNotFoundException("Address not found with id " + id);
        }
    }

    // Méthode pour récupérer toutes les adresses
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();  // Utilisation correcte de addressRepo
    }
    @Override
    public void deleteAddress(long id) {
        // Suppression simple sans vérification préalable
        addressRepository.deleteById(id);
    }
}
