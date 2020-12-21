package springangular.crud.repositories;

import springangular.crud.models.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    UserAddress findByIdAndDeletedAtIsNull(Long id);
    List<UserAddress> findAllByUserId(Long id);
}
