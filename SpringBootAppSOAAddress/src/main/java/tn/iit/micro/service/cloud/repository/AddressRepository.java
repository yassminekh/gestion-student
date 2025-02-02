package tn.iit.micro.service.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.micro.service.cloud.entities.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
