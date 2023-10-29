package lk.ijse.gdse63.aad.user_authorized_service.repo;

import lk.ijse.gdse63.aad.user_authorized_service.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByUserName (String username);


}
