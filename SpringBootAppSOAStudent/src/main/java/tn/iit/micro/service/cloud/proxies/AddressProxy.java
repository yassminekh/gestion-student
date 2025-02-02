package tn.iit.micro.service.cloud.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.iit.micro.service.cloud.dto.AddressRequest;
import tn.iit.micro.service.cloud.dto.AddressResponse;

import java.util.List;

@FeignClient(value = "SPRINGBOOTAPPSOAADDRESS", path = "/address/api")
public interface AddressProxy {

    @PostMapping("/create")
    AddressResponse createAddress(@RequestBody AddressRequest address);

    @GetMapping("/getAllAddress")
    List<AddressResponse> getAll();

    @GetMapping("/getById/{id}")
    AddressResponse getById(@PathVariable long id);
}