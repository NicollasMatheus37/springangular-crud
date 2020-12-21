package springangular.crud.services;

import springangular.crud.models.UserPhone;
import springangular.crud.repositories.UserPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserPhoneService {

    private final UserPhoneRepository userPhoneRepository;

    @Autowired
    public UserPhoneService(UserPhoneRepository userPhoneRepository) {
        this.userPhoneRepository = userPhoneRepository;
    }

    public List<UserPhone> getAllByUserId(Long id) {
        return userPhoneRepository.findAllByUserId(id);
    }

    public List<UserPhone> sync(List<UserPhone> userPhones) {
        for (UserPhone userPhone : userPhones) {
            if (userPhone.getId() != null) {
                userPhone.setUpdatedAt(LocalDateTime.now());
            }

            userPhone.setCreatedAt(LocalDateTime.now());
            userPhone.setUpdatedAt(LocalDateTime.now());

            userPhoneRepository.save(userPhone);
        }

        return userPhones;
    }

    public void delete(Long id) {
        userPhoneRepository.deleteById(id);
    }
}
