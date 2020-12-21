package springangular.crud.models;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_phones")
public class UserPhone {

    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "ddd")
    private String ddd;

    @Column(name = "phone")
    private String phone;

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

    public UserPhone setId(Long id) {
        this.id = id;

        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserPhone setPhone(String phone) {
        this.phone = phone;

        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserPhone setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserPhone setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public UserPhone setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;

        return this;
    }

    public String getDdd() {
        return ddd;
    }

    public UserPhone setDdd(String ddd) {
        this.ddd = ddd;

        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserPhone setUserId(Long userId) {
        this.userId = userId;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPhone)) return false;

        UserPhone userPhone = (UserPhone) o;

        if (!getId().equals(userPhone.getId())) return false;
        if (!getPhone().equals(userPhone.getPhone())) return false;
        if (!getUserId().equals(userPhone.getUserId())) return false;
        if (getCreatedAt() != null ? !getCreatedAt().equals(userPhone.getCreatedAt()) : userPhone.getCreatedAt() != null)
            return false;
        if (getUpdatedAt() != null ? !getUpdatedAt().equals(userPhone.getUpdatedAt()) : userPhone.getUpdatedAt() != null)
            return false;
        return getDeletedAt() != null ? getDeletedAt().equals(userPhone.getDeletedAt()) : userPhone.getDeletedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getPhone().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        result = 31 * result + (getDeletedAt() != null ? getDeletedAt().hashCode() : 0);
        return result;
    }
}
