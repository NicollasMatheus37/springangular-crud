package springangular.crud.controllers;

import springangular.crud.models.UserPhone;
import springangular.crud.services.UserPhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-phones")
public class UserPhoneController {

    private final UserPhoneService userPhoneService;

    public UserPhoneController(UserPhoneService userPhoneService) {
        this.userPhoneService = userPhoneService;
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserPhone>> getAll(@PathVariable Long userId) {
        return new ResponseEntity<>(userPhoneService.getAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserPhone>> update(@RequestBody List<UserPhone> userPhonees) {
        return new ResponseEntity<>(userPhoneService.sync(userPhonees), HttpStatus.OK);
    }

    @DeleteMapping(path = "{userPhoneId}")
    public void delete(@PathVariable Long userPhoneId) {
        userPhoneService.delete(userPhoneId);
    }
}
