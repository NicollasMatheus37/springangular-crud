package springangular.crud.repositories;

import springangular.crud.models.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {
    UserPhone findByIdAndDeletedAtIsNull(Long id);
    List<UserPhone> findAllByUserId(Long id);
}
