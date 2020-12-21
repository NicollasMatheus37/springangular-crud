package springangular.crud.services;

import springangular.crud.exceptions.UserException;
import springangular.crud.helpers.CpfCnpjValidator;
import springangular.crud.models.User;
import springangular.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAllByDeletedAtIsNull();
    }

    public User getById(Long id) {

        User user = userRepository.findByIdAndDeletedAtIsNull(id);

        if (user == null) {
            throw new UserException("User doesn't exists");
        }

        return user;
    }

    public User create(User user) {
        if (userRepository.existsByNameAndDeletedAtIsNull(user.getName())) {
            throw new UserException("User already exists");
        }

        if (userRepository.existsByCpfcnpjAndDeletedAtIsNull(user.getCpfcnpj())) {
            throw new UserException("User already exists");
        }

        if (!validateCpfcnpj(user.getCpfcnpj())) {
            throw new UserException("Invalid cpfcnpj");
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()))
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User update(User user) {
        if (user == null) {
            throw new UserException("User doesn't exists");
        }

        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findByIdAndDeletedAtIsNull(id);

        if (user != null) {
            user.setUpdatedAt(LocalDateTime.now())
                .setDeletedAt(LocalDateTime.now());

            userRepository.save(user);
        }
    }

    public User authenticate(User requestUser) {
        if (requestUser == null) {
            throw new UserException("Wrong email or password");
        }

        User user = userRepository.findByNameAndDeletedAtIsNull(requestUser.getName());

        if (user == null || !new BCryptPasswordEncoder().matches(requestUser.getPassword(), user.getPassword())) {
            throw new UserException("Wrong email or password");
        }

        return user;
    }

    public boolean validateCpfcnpj(String cpfcnpj) {
        if (userRepository.existsByCpfcnpjAndDeletedAtIsNull(cpfcnpj)) {
            throw new UserException("Cpfcnpj already exists");
        }

        return CpfCnpjValidator.isValid(cpfcnpj);
    }
}
