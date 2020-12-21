package springangular.crud.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "cpfcnpj")
    private String cpfcnpj;

    @Column(name = "created_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime deletedAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<UserAddress> userAddresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<UserPhone> userPhones = new ArrayList<>();

    @Autowired
    public User() { }

    public User(@JsonProperty("id") Long id,
                @JsonProperty("name") String name,
                @JsonProperty("password") String password,
                @JsonProperty("cpfcnpj") String cpfcnpj) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.cpfcnpj = cpfcnpj;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public User setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;

        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public User setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;

    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public User setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;

        return this;
    }

    public List<UserPhone> getUserPhones() {
        return userPhones;
    }

    public User setUserPhones(List<UserPhone> userPhones) {
        this.userPhones = userPhones;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getCpfcnpj() != null ? !getCpfcnpj().equals(user.getCpfcnpj()) : user.getCpfcnpj() != null) return false;
        if (getCreatedAt() != null ? !getCreatedAt().equals(user.getCreatedAt()) : user.getCreatedAt() != null)
            return false;
        if (getUpdatedAt() != null ? !getUpdatedAt().equals(user.getUpdatedAt()) : user.getUpdatedAt() != null)
            return false;
        return getDeletedAt() != null ? getDeletedAt().equals(user.getDeletedAt()) : user.getDeletedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getCpfcnpj() != null ? getCpfcnpj().hashCode() : 0);
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        result = 31 * result + (getDeletedAt() != null ? getDeletedAt().hashCode() : 0);
        return result;
    }
}
