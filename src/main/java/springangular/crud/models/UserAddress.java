package springangular.crud.models;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_addresses")
public class UserAddress {

    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "created_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public UserAddress setId(Long id) {
        this.id = id;

        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserAddress setAddress(String address) {
        this.address = address;

        return this;
    }

    public String getState() {
        return state;
    }

    public UserAddress setState(String state) {
        this.state = state;

        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserAddress setCountry(String country) {
        this.country = country;

        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserAddress setUserId(Long userId) {
        this.userId = userId;

        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserAddress setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserAddress setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getNumber() {
        return number;
    }

    public UserAddress setNumber(String number) {
        this.number = number;

        return this;
    }

    public String getCity() {
        return city;
    }

    public UserAddress setCity(String city) {
        this.city = city;

        return this;
    }

    public String getDistrict() {
        return district;
    }

    public UserAddress setDistrict(String district) {
        this.district = district;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAddress)) return false;

        UserAddress that = (UserAddress) o;

        if (!getId().equals(that.getId())) return false;
        if (!getAddress().equals(that.getAddress())) return false;
        if (!getState().equals(that.getState())) return false;
        if (!getCountry().equals(that.getCountry())) return false;
        if (getCreatedAt() != null ? !getCreatedAt().equals(that.getCreatedAt()) : that.getCreatedAt() != null)
            return false;
        if (getUpdatedAt() != null ? !getUpdatedAt().equals(that.getUpdatedAt()) : that.getUpdatedAt() != null)
            return false;
        return getDeletedAt() != null ? getDeletedAt().equals(that.getDeletedAt()) : that.getDeletedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        result = 31 * result + (getDeletedAt() != null ? getDeletedAt().hashCode() : 0);
        return result;
    }
}
