package springangular.crud.controllers;

import springangular.crud.models.UserAddress;
import springangular.crud.services.UserAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-addresses")
public class UserAddressController {

    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserAddress>> getAllByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(userAddressService.getAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserAddress>> update(@RequestBody List<UserAddress> userAddresses) {
        return new ResponseEntity<>(userAddressService.sync(userAddresses), HttpStatus.OK);
    }

    @DeleteMapping(path = "{userAddressId}")
    public void delete(@PathVariable Long userAddressId) {
        userAddressService.delete(userAddressId);
    }
}
