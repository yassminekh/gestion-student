package tn.iit.micro.service.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.micro.service.cloud.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
