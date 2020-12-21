package springangular.crud.repositories;

import springangular.crud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCpfcnpjAndDeletedAtIsNull(String cpfcnpj);
    boolean existsByNameAndDeletedAtIsNull(String name);
    User findByIdAndDeletedAtIsNull(Long id);
    List<User> findAllByDeletedAtIsNull();
    User findByNameAndDeletedAtIsNull(String name);
}
