package springangular.crud.services;

import springangular.crud.models.UserAddress;
import springangular.crud.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAddressService {

    private final UserAddressRepository userAddressRepository;

    @Autowired
    public UserAddressService(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    public List<UserAddress> getAllByUserId(Long id) {
        return userAddressRepository.findAllByUserId(id);
    }

    public List<UserAddress> sync(List<UserAddress> userAddresses) {
        for (UserAddress userAddress : userAddresses) {
            if (userAddress.getId() != null) {
                userAddress.setUpdatedAt(LocalDateTime.now());
            }

            userAddress.setCreatedAt(LocalDateTime.now());
            userAddress.setUpdatedAt(LocalDateTime.now());

            userAddressRepository.save(userAddress);
        }

        return userAddresses;
    }

    public void delete(Long id) {
        userAddressRepository.deleteById(id);
    }
}
